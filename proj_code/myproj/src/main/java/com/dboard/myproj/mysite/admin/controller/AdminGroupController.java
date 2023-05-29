package com.dboard.myproj.mysite.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/mysite/admin")
public class AdminGroupController {

    @GetMapping("/group")
    public String groupAdmin() {

        return null;
    }


}
