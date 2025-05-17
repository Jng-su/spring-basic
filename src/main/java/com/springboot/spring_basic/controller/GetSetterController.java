package com.springboot.spring_basic.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/basic")
public class GetSetterController {

    static class CarV1 {
        private final int id;
        private final int speed;
        private final String name;
        private final List<Integer> relatedIds;

        public CarV1(int id, int speed, String name, List<Integer> relatedIds) {
            this.id = id;
            this.speed = speed;
            this.name = name;
            this.relatedIds = relatedIds;
        }

        public int getId() {
            return id;
        }

        public int getSpeed() {
            return speed;
        }

        public String getName() {
            return name;
        }

        public List<Integer> getRelatedIds() {
            return relatedIds;
        }
    }

    @AllArgsConstructor
    @Getter
    static class CarV2 {
        private final int id;
        private final int speed;
        @Setter
        private String name;
        private final List<Integer> relatedIds;
    }

    // 단일 Map 반환 예제
    @GetMapping("/info")
    public Map<String, Object> getCarInfoAsMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("speed", 1000);
        map.put("name", "Tesla");
        map.put("relatedIds", List.of(1, 2, 3));
        return map;
    }

    // CarV1 객체 반환
    @GetMapping("/v1")
    public CarV1 getCarV1() {
        return new CarV1(1, 1000, "Tesla", List.of(4, 5, 6));
    }

    // CarV2 객체 반환
    @GetMapping("/v2")
    public CarV2 getCarV2() {
        CarV2 car = new CarV2(1, 1000, "Tesla", List.of(4, 5, 6));
        car.setName(car.getName() + "_v1");
        return car;
    }

    @GetMapping("/info/list")
    public List<Map<String, Object>> getCarInfoList() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", i);
            map.put("speed", 900 + i * 50);
            map.put("name", "Car" + i);
            map.put("relatedIds", List.of(i, i + 1, i + 2));
            result.add(map);
        }
        return result;
    }

    @GetMapping("/v2/sample")
    public List<CarV2> getSampleCarV2List() {
        return List.of(new CarV2(10, 950, "Hyundai", List.of(1, 2)), new CarV2(11, 980, "Kia", List.of(3, 4)), new CarV2(12, 1020, "Genesis", List.of(5, 6)));
    }
}