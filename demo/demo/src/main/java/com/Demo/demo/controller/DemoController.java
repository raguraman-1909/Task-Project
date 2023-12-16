package com.Demo.demo.controller;


import com.Demo.demo.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-post")
public class DemoController {

    @GetMapping("{userId}")
    public DemoClass getDemoDetails(String userId){
        return new DemoClass("u1", "admin");
    }
}

