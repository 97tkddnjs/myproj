package com.dboard.myproj.mysite.admin.controller;


import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.entity.Member;
import com.dboard.myproj.mysite.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *  1. 만들것이 전체 화면
 *  2. search <- post
 *  3. member detail <- group, 등등~ 뭐 이리 복잡하니...
 *  4. admin group <- pop up 방식으로다가
 *
 *
 * */

@RequestMapping("/mysite/admin")
@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {


    private final AdminService service;

    @GetMapping("/home")
    public String index() {
        //System.out.println("inthe =  /" );
        log.info("admin index page into ");

        return "mysite/admin/index";
    }

    /**
     *  회원 관리를 보여주는 URL
     *  처음 접속시 전체 데이터 보여주어야 함
     *  admin은 따로 터치 x~
     */
    @GetMapping("/member")
    public String memberAdmin(Model model) {


        List<AdminMemberDTO> allUserMember = service.findAllUserMember();
        model.addAttribute("allmember",allUserMember);


        return "mysite/admin/adminmember";
    }
    @GetMapping("/modal")
    public String modal() {
        //System.out.println("inthe =  /" );
        log.info("modal page into ");

        return "mysite/admin/modal";
    }

}
