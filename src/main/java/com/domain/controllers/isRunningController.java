package com.domain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/isRunning")
public class isRunningController {
    
    @GetMapping
    public String welcome(){
        return "Springboot is Running";
    }
}
