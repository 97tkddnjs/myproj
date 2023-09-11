package com.dboard.myproj.mysite.user.controller;

import com.dboard.myproj.config.AuthConst;
import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.dto.MemberDetailFormDTO;
import com.dboard.myproj.data.entity.BoardDetailVO;
import com.dboard.myproj.data.entity.MemberVO;
import com.dboard.myproj.mysite.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


    @GetMapping("{cb_type}/{class_id}/{board_id}")
    public String boardDetail( @PathVariable String cb_type
            , @PathVariable String class_id, @PathVariable String board_id,
                               HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        MemberVO attribute = (MemberVO)session.getAttribute(AuthConst.LOGIN_MEMBER);
        String member_id = attribute.getMember_id();


        log.info("====== board ======");

        List<ClassCodeDTO> userBoardList =  userService.userBoardListById(member_id);

        model.addAttribute("userboardlist", userBoardList);

        List<BoardDetailVO> boardDetailVOS =  userService.findAllBoardDetail(cb_type);

        model.addAttribute("boarddetail",boardDetailVOS);

        return "mysite/user/user_board";
    }

}
