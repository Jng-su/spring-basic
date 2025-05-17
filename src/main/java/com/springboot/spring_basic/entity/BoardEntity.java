package com.springboot.spring_basic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String boardWriter;

    @Column(length = 10, nullable = false)
    private String boardTitle;
}
