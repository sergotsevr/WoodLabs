package com.woodlabs.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
@Slf4j
public class AdminController {
    @GetMapping()
    public String main(){
        return "admin";
    }
}
