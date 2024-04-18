package com.example.chapter01test.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question1")
public class HomeController {
    @RequestMapping
    public String index() {
        return "<h1>Welcome to the Schedule Management System</h1>" +
        "<a href='/question2/index'>Go to Schedule List</a>";
    }
}
