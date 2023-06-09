package com.dboard.myproj.mysite.admin.controller;


import com.dboard.myproj.config.page.PagingResponse;
import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.entity.Group;
import com.dboard.myproj.data.entity.Member;
import com.dboard.myproj.mysite.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
    public String index(Model model ) {
        //System.out.println("inthe =  /" );
        log.info("admin index page into ");
        List<Group> allGroup = service.findAllGroup();
        model.addAttribute("group", allGroup);

        return "mysite/admin/index";
    }

    /**
     *  회원 관리를 보여주는 URL
     *  처음 접속시 전체 데이터 보여주어야 함
     *  admin은 따로 터치 x~
     */
    @GetMapping("/member")
    public String memberAdmin(@ModelAttribute("params") final SearchDto params,
                              Model model) {


        PagingResponse<AdminMemberDTO> allUserMember = service.findAllUserMember(params);
        model.addAttribute("allmember",allUserMember);

        return "mysite/admin/adminmember";
    }

    /**
     *  그룹이랑 제한 여부 정도만 건들일 수 있음....
     *
     * */
    @GetMapping("/member/detail")
    public String memberdetail(@RequestParam("email") String email,  Model model ) {
        //System.out.println("inthe =  /" );
        log.info("modal page into " + email);

        AdminMemberDTO memberDetail = service.findUserMemberByEmail(email);
        log.info("member detail",memberDetail);
        List<Group> allGroup = service.findAllGroup();

        log.info("send modal info : " + memberDetail);
        model.addAttribute("member", memberDetail);
        model.addAttribute("groups",allGroup);
        return "mysite/admin/memberdetail";
    }


    @GetMapping("/member/search")
    public String memberDetailSearch(@RequestParam("condition") int condition,
                                     @RequestParam("name") String name,
                                     @ModelAttribute("params") final SearchDto params,
                                     Model model) {
        PagingResponse<AdminMemberDTO> userMembers =null;


        if(condition==1){

            userMembers = service.searchMemberName(name, params);

            List<AdminMemberDTO> list = userMembers.getList();
            list.stream().forEach(
                    member_admin -> System.out.println("member_admin = " + member_admin)
            );
            System.out.println("list.size() = " + list.size());
            log.info("condition1 size ");

        } else if (condition == 2) {
            // 그룹 검색
        }else if (condition ==3){
            // 제한회원 검색
        }

        model.addAttribute("allmember",userMembers);

        return  "mysite/admin/adminmember";
    }



    @GetMapping("/group")
    public String makeGroup() {

        service.findAllGroup();
        return "";
    }

    /**
     *
     *
     * */

    @GetMapping("/board")
    public String boardAdmin() {


        return null;
    }
}
