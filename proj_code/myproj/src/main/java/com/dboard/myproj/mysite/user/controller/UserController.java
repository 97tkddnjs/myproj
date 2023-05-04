package com.dboard.myproj.mysite.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mysite/user")
@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @GetMapping("/home")
    public String index() {
        return "";
    }

}
