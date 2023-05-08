package com.dboard.myproj.common.controller;

import com.dboard.myproj.data.dto.MemberFormDto;
import com.dboard.myproj.common.service.AuthenticationService;
import com.dboard.myproj.config.AuthConst;
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
            @ModelAttribute("memberForm") MemberFormDto memberForm,
            Model model

    ) {
//        model.addAttribute("msg", msg);
        return "login/loginform";
    }
    // reload 즉 f5키는 post를 부르게 된다.
    @PostMapping("/")
    public String index2(
            @ModelAttribute("memberForm") MemberFormDto memberForm,
            Model model

    ) {
//        model.addAttribute("msg", msg);
        return "login/loginform";
    }

    @PostMapping("/login")
    public String loginPost(
            @ModelAttribute("memberForm") MemberFormDto memberForm,
            HttpServletRequest request
            ) {
        log.info("login "+memberForm);
        Member login_member = authservice.login(memberForm);
        log.info("info member "+login_member);
        if(login_member !=null){
            HttpSession session = request.getSession(true);
            session.setAttribute(AuthConst.LOGIN_MEMBER, login_member);

            if(login_member.getGrade_id()==1){
                return "redirect:/mysite/admin/home";
            }else{
                return "redirect:/mysite/user/";
            }

        }else{
            return "login/loginform";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }


    @GetMapping("/signup")
    public String signup(
            @ModelAttribute("member") MemberFormDto memberFormDto
    ) {
        return "login/signupform";
    }

    @PostMapping("/signup")
    public String signupPost(
            @ModelAttribute("member") MemberFormDto memberFormDto,
            RedirectAttributes re
    ) {

//        System.out.println("member = " + memberFormDto);
        log.info("member show "+memberFormDto);

        boolean sign = authservice.signUp(memberFormDto);


        if (sign) {
            log.info("dddd");
            re.addFlashAttribute("msg", "ok pass");
        }else{
            re.addFlashAttribute("msg", "sorry fail");
        }

        return "redirect:/";

    }

}
