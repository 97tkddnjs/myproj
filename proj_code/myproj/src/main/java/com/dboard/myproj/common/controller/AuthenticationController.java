package com.dboard.myproj.common.controller;

import com.dboard.myproj.common.dto.LoginForm;
import com.dboard.myproj.common.dto.MemberFormDto;
import com.dboard.myproj.common.service.AuthenticationService;
import com.dboard.myproj.config.SessionConst;
import com.dboard.myproj.data.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/mysite")
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authservice;

    @GetMapping("/")
    public String index(
            Model model

    ) {
//        model.addAttribute("msg", msg);
        return "login/loginform";
    }


    @PostMapping("/")
    public String indexPost(
            @ModelAttribute("loginForm") MemberFormDto loginForm,
            HttpServletRequest request
            ) {

        Member login_member = authservice.login(loginForm);

        if(login_member !=null){
            HttpSession session = request.getSession(true);
            session.setAttribute(SessionConst.LOGIN_MEMBER, login_member);

            if(login_member.getGrade_id()==1){
                return "redirect:/mysite/admin";
            }else{
                return "redirect:/mysite/user";
            }

        }else{
            return "login/loginform";
        }
    }


    @GetMapping("/signup")
    public String signup(
            @ModelAttribute("member") MemberFormDto memberFormDto
    ) {
        return "login/signupform";
    }

    @PostMapping("signup")
    public String signupPost(
            @ModelAttribute("member") MemberFormDto memberFormDto,
            RedirectAttributes re
    ) {

//        System.out.println("member = " + memberFormDto);
        log.info("member show "+memberFormDto);

        boolean sign = authservice.signUp(memberFormDto);

        //https://mine-it-record.tistory.com/416

        if (sign) {
            log.info("dddd");
            re.addFlashAttribute("msg", "ok pass");
        }else{
            re.addFlashAttribute("msg", "sorry fail");
        }

        return "redirect:/";

    }

}
