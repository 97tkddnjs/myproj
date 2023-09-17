package com.dboard.myproj.mysite.user.controller;


import com.dboard.myproj.config.AuthConst;
import com.dboard.myproj.data.dto.BoardRegDTO;
import com.dboard.myproj.data.dto.ClassBoardTypeDTO;
import com.dboard.myproj.data.dto.ClassCodeDTO;

import com.dboard.myproj.data.dto.SignupDTO;
import com.dboard.myproj.data.entity.CommentsVO;
import com.dboard.myproj.data.entity.MemberVO;
import com.dboard.myproj.mysite.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mysite/user/rest")
public class RestUserController {

    private final UserService service;



//    @PostMapping(value = "/register/class")
//    Map<String , String> registerClass(@RequestBody ClassCodeDTO classCodeDTO){
//
//        log.info(" register class code "+classCodeDTO);
//        int flag =  service.saveClassCode(classCodeDTO);
//        Map<String, String> response = new HashMap<>();
//        if(flag>0) {
//            response.put("result", "ok");
//        }else {
//            response.put("result", "fail");
//        }
//        return response;
//    }


    @PostMapping ("/board")
    public ResponseEntity<List<ClassBoardTypeDTO>> boardDetail(@RequestBody String class_id) {

        log.info("----------- call  11111 "+class_id);

        String data= class_id.split("=")[1];
        List<ClassBoardTypeDTO> classBoardTypeDTOS =  service.findClassBoardTypeByID(data);


//        Map<String, List<ClassBoardTypeDTO>> map = new HashMap<>();

//        map.put("list", classBoardTypeDTOS);
        return ResponseEntity.ok(classBoardTypeDTOS);

    }

    @PostMapping("/board/register")
    public ResponseEntity boaardRegister(@ModelAttribute BoardRegDTO boardRegDTO) throws IOException {
        log.info("========== into the here   " + boardRegDTO);
        Boolean flag = service.savedBoard(boardRegDTO);
        if(flag){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("fail");
        }

    }


    @PostMapping("/update/comment")
    public ResponseEntity commentUpdate(@RequestBody CommentsVO comment,
                                        HttpServletRequest request){

        HttpSession session = request.getSession();
        MemberVO attribute = (MemberVO)session.getAttribute(AuthConst.LOGIN_MEMBER);
        String member_id = attribute.getMember_id();


        LocalDateTime now = LocalDateTime.now();
        comment.setMember_id(member_id);
        comment.setCom_dt(now);

        int flag = service.saveComment(comment);

        if(flag > 0){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("fail");
        }

    }

    public ResponseEntity userInfoUpdate(@ModelAttribute SignupDTO signupDTO){

        return ResponseEntity.ok("ok");

    }

//    @PostMapping("/class/{classID}")
//    ResponseEntity updateClass(@PathVariable("classID") String classID ,
//                               @RequestBody ClassCodeDTO classCodeDTO){
//
//        log.info(" ======= class ID ===== "+ classCodeDTO);
//
//        int flag = service.updateClassCodeById(classCodeDTO);
//
//        return null;
//    }

//    @PostMapping (value = "/meber/update")
//    Map<String, String> updateMember(@RequestBody AdminMemberDTO member) {
//
//        log.info("rest check "+member);
//        int flag = service.updateMemberByEmail(member);
//
//        Map<String, String> response = new HashMap<>();
//        response.put("result","ok" );
//
//        return response;
//    }


}
