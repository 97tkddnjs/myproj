package com.dboard.myproj.mysite.admin.controller;


import com.dboard.myproj.config.page.PagingResponse;
import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.*;

import com.dboard.myproj.data.entity.BoardTypeVO;
import com.dboard.myproj.data.entity.ClassCodeVO;
import com.dboard.myproj.mysite.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  @author : lsw
 *
 *  1. 만들것이 전체 화면
 *
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


        return "mysite/admin/index";
    }

    /**
     *  회원 관리를 보여주는 URL
     *  처음 접속시 전체 데이터 보여주어야 함
     *  admin은 따로 터치 x~
     * @param : SearchDto
     * @description :
     */
    @GetMapping("/member")
    public String memberAdmin(@ModelAttribute("params") final SearchDto params,
                              Model model) {

        log.info("====== search ====== {}", params);
        PagingResponse<AdminMemberDTO> allUserMember = service.findAllUserMember(params);
        model.addAttribute("allmember",allUserMember);

        return "mysite/admin/manage_member";
    }
    @GetMapping("/member/{memberId}")
    public String memberdetail(@PathVariable("memberId") String memberId,  Model model ) {

        MemberDetailFormDTO memberDetailFormDTO = service.findMemberDetailById(memberId);

        model.addAttribute("memberdetail", memberDetailFormDTO);

        return "mysite/admin/member_detail";
    }


    @GetMapping("/class")
    public String classAdmin(@ModelAttribute("params") final SearchDto params,
                             Model model) {


        log.info("====== search ====== {}", params);
        params.setRecordSize(5);
        PagingResponse<ClassCodeVO> classCode =  service.findAllClass(params);
        model.addAttribute("classCode",classCode);
        return "mysite/admin/manage_class";
    }

    @GetMapping("/class/register")
    public String classRegister(@ModelAttribute("classCode") ClassCodeDTO classCode) {

        log.info("=== class register ====");

        return "mysite/admin/register_class";
    }
    @GetMapping("/class/{classId}")
    public String classDetail(@PathVariable("classId") String classId, Model model ) {


        log.info("=========== classdetail ==========  "+classId);
        ClassCodeDTO classCodeDTO= service.findClassCodeById(classId);
        log.info("=========== classCode ==========  "+classCodeDTO);
        model.addAttribute("classCode", classCodeDTO);

        return "mysite/admin/class_detail";
    }




    @GetMapping("/board")
    public String boardAdmin(@ModelAttribute("params") final SearchDto params,
                             Model model) {

        List< AdminBoardDTO> adminBoardDTOS =service.findAllBoard(params);
        adminBoardDTOS.forEach(
                adminBoardDTO->   System.out.println("adminBoardDTOS = " + adminBoardDTO)
        );
        model.addAttribute("curymdboard",adminBoardDTOS);
        return "mysite/admin/manage_board";
    }


    @GetMapping("/board/register")
    public String boardRegister(Model model) {

        List<BoardTypeVO> boardTypeVOs =  service.findAllBoardType();
        boardTypeVOs.forEach(
                i -> System.out.println("i = " + i)
        );
        log.info("here    " ,boardTypeVOs.size(),boardTypeVOs);
        model.addAttribute("boardTypes",boardTypeVOs);
        return "mysite/admin/register_board";
    }

    @GetMapping("/board/detail/{classId}/{classNm}")
    public String boardDetail( @PathVariable("classId") int classId,
            @PathVariable("classNm") String classNm ,Model model) {

        log.info("/mysite/admin/board/detail/"+classId);

        List<BoardTypeDTO> boardTypeDTOS= service.findRegClassByClassId(classId);

        model.addAttribute("regclass", classNm);
        model.addAttribute("classId", classId);
        model.addAttribute("regboards",boardTypeDTOS);
        return "mysite/admin/board_detail";
    }

//     * */


//
//
//    @GetMapping("/member/search")
//    public String memberDetailSearch(@RequestParam("condition") int condition,
//                                     @RequestParam("name") String name,
//                                     @ModelAttribute("params") final SearchDto params,
//                                     Model model) {
//        PagingResponse<AdminMemberDTO> userMembers =null;
//
//
//        if(condition==1){
//
//            userMembers = service.searchMemberName(name, params);
//
//            List<AdminMemberDTO> list = userMembers.getList();
//            list.stream().forEach(
//                    member_admin -> System.out.println("member_admin = " + member_admin)
//            );
//            System.out.println("list.size() = " + list.size());
//            log.info("condition1 size ");
//
//        } else if (condition == 2) {
//            // 그룹 검색
//        }else if (condition ==3){
//            // 제한회원 검색
//        }
//
//        model.addAttribute("allmember",userMembers);
//
//        return  "mysite/admin/adminmember";
//    }
//
//
//
//    @GetMapping("/group")
//    public String makeGroup() {
//
//        service.findAllGroup();
//        return "";
//    }
//
//    /**
//     *
//     *
//     * */
//
//    @GetMapping("/board")
//    public String boardAdmin() {
//
//
//        return null;
//    }
}
