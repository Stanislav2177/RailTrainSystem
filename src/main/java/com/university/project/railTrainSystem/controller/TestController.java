package com.university.project.railTrainSystem.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @GetMapping("/api/test")
    private String test(){
        return "test";
    }
}
