package com.springboot.spring_basic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {
    @GetMapping("/save")
    public String save() {
        return "save";
    }
}
