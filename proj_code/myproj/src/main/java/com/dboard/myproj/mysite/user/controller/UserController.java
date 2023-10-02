package com.dboard.myproj.mysite.user.controller;

import com.dboard.myproj.config.AuthConst;
import com.dboard.myproj.config.page.PagingResponse;
import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.dto.MemberDetailFormDTO;
import com.dboard.myproj.data.entity.BoardDetailVO;
import com.dboard.myproj.data.entity.CommentsVO;
import com.dboard.myproj.data.entity.MemberVO;
import com.dboard.myproj.mysite.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequestMapping("/mysite/user")
@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {


    @Autowired
    private  final UserService userService;

    @GetMapping("/home")
    public String index(HttpServletRequest request, Model model) {


        HttpSession session = request.getSession();

        MemberVO attribute = (MemberVO)session.getAttribute(AuthConst.LOGIN_MEMBER);
        String member_id = attribute.getMember_id();

        List<ClassCodeDTO> userBoardList =  userService.userBoardListById(member_id);

        model.addAttribute("userboardlist", userBoardList);

        return "mysite/user/index";
    }

    @GetMapping("/userpage/{memberID}")
    public String userpage(@PathVariable("memberID") String member_id, Model model) {


        log.info("============ in te======");


        List<ClassCodeDTO> userBoardList =  userService.userBoardListById(member_id);

        model.addAttribute("userboardlist", userBoardList);


        MemberDetailFormDTO memberDetailFormDTO = userService.findUserDetailByID(member_id);
        model.addAttribute("memberdetail", memberDetailFormDTO);



        return "mysite/user/user_member_detail";

    }


    @GetMapping("{cb_type}/{class_nm}/{board_nm}")
    public String board(@ModelAttribute("params") final SearchDto params, @PathVariable String cb_type
            , @PathVariable String class_nm, @PathVariable String board_nm,
                              HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        MemberVO attribute = (MemberVO)session.getAttribute(AuthConst.LOGIN_MEMBER);
        String member_id = attribute.getMember_id();


        log.info("====== board ======");

        // 기본 게시판 보여주기 navbar
        List<ClassCodeDTO> userBoardList =  userService.userBoardListById(member_id);
        model.addAttribute("userboardlist", userBoardList);
        //

        model.addAttribute("boardname", class_nm + " " + board_nm);


        PagingResponse<BoardDetailVO> boardDetailVOS =  userService.findAllBoardDetail(cb_type, params);

        model.addAttribute("boarddetail",boardDetailVOS);

        return "mysite/user/user_board";
    }


    @GetMapping("{cb_type}/{class_nm}/{board_nm}/register")
    public String boardRegister(@ModelAttribute("params") final SearchDto params, @PathVariable String cb_type
            , @PathVariable String class_nm, @PathVariable String board_nm,
                              HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        MemberVO attribute = (MemberVO)session.getAttribute(AuthConst.LOGIN_MEMBER);
        String member_id = attribute.getMember_id();

        // 기본 게시판 navbar
        List<ClassCodeDTO> userBoardList =  userService.userBoardListById(member_id);

        model.addAttribute("userboardlist", userBoardList);

        log.info("====== board register ======");
        model.addAttribute("cb_type",cb_type);
        model.addAttribute("boardname", class_nm + " " + board_nm);
        model.addAttribute("member_id", member_id);

//        List<ClassCodeDTO> userBoardList =  userService.userBoardListById(member_id);
//
//        model.addAttribute("userboardlist", userBoardList);



        return "mysite/user/register_board";
    }


    @GetMapping("{cb_type}/{class_nm}/{board_nm}/detail/{bdId}")
    public String boardDetail(@ModelAttribute("params") final SearchDto params
            , @PathVariable String cb_type, @PathVariable String class_nm
            , @PathVariable String board_nm,@PathVariable("bdId") int bd_id,
                                HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        MemberVO attribute = (MemberVO)session.getAttribute(AuthConst.LOGIN_MEMBER);
        String member_id = attribute.getMember_id();

        // 기본 게시판 navbar
        List<ClassCodeDTO> userBoardList =  userService.userBoardListById(member_id);

        model.addAttribute("userboardlist", userBoardList);

        log.info("====== board register ======");
        model.addAttribute("cb_type",cb_type);
        model.addAttribute("boardname", class_nm + " " + board_nm);
        model.addAttribute("member_id", member_id);




        BoardDetailVO boardDetailVO = userService.findBoardDetailById(bd_id);
        model.addAttribute("board_detail", boardDetailVO);

        List<CommentsVO> commentsVOS = userService.findAllCommentsByBd(bd_id);
        model.addAttribute("comments_list", commentsVOS);

        return "mysite/user/user_board_detail";
    }


    @GetMapping("{cb_type}/update/{bdId}")
    String boardDetailUpdate(@PathVariable String cb_type,
                             @PathVariable("bdId") int bd_id
                            , Model model,HttpServletRequest request) {

        HttpSession session = request.getSession();
        MemberVO attribute = (MemberVO)session.getAttribute(AuthConst.LOGIN_MEMBER);
        String member_id = attribute.getMember_id();

        // 기본 게시판 navbar
        List<ClassCodeDTO> userBoardList =  userService.userBoardListById(member_id);

        model.addAttribute("userboardlist", userBoardList);

        // 내용 조회 뿌리기
        BoardDetailVO boardDetailVO = userService.findBoardDetailById(bd_id);

        model.addAttribute("boardDetail", boardDetailVO);
        model.addAttribute("cb_type",cb_type);
        model.addAttribute("bd_id",bd_id);

        return "mysite/user/update_board";
    }




    @GetMapping(value = "board/detail/download/{addpath}")
    public ResponseEntity<UrlResource> fileDownloadApi(@PathVariable("addpath") String addPath) throws IOException {

        log.info("== in fil upload == "+addPath);
        UrlResource resource = userService.readFileAsResource(addPath);

        String[] data = addPath.split("/");
        String filename = data[data.length-1];
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .cacheControl(CacheControl.noCache())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +filename)
                .body(resource);
    }

}
