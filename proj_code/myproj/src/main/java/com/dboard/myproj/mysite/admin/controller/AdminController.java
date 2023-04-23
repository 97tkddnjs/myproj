package com.dboard.myproj.mysite.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mysite/admin")
@Controller
public class AdminController {

    @GetMapping("/")
    public String index() {
        return "mysite/admin/index";
    }
}
