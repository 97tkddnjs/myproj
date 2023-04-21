package com.dboard.myproj.common.controller;


import com.dboard.myproj.common.dto.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Test {

    @GetMapping("/")
    public String test(@ModelAttribute("loginForm") LoginForm loginForm) {
        return "login/loginform";
    }
}
