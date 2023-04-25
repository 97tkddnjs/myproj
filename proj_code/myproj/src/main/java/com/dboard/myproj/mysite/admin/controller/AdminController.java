package com.dboard.myproj.mysite.admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mysite/admin")
@Controller
@Slf4j
public class AdminController {

    @GetMapping("/home")
    public String index() {
        //System.out.println("inthe =  /" );
        log.info("admin index page into ");

        return "mysite/admin/index";
    }

    @GetMapping("/member")
    public String memberAdmin() {

        return "mysite/admin/adminmember";
    }
}
