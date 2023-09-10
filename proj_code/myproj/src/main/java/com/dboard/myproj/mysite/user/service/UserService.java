package com.dboard.myproj.mysite.user.service;


import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.dto.ClassBoardTypeDTO;
import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.dto.MemberDetailFormDTO;
import com.dboard.myproj.mysite.user.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
//@RequiredArgsConstructor
public class UserService {

    private final UserDAO dao;

    @Autowired
    UserService(UserDAO userDAO) {
        this.dao = userDAO;
    }


    public MemberDetailFormDTO findUserDetailByID(String member_id) {

        AdminMemberDTO userMemberByID = dao.findUserMemberByID(member_id);
        List<ClassCodeDTO> classCodeDTOS =  dao.findAllClassCode(member_id);

        MemberDetailFormDTO memberDetailFormDTO = new MemberDetailFormDTO();
        memberDetailFormDTO.setMember(userMemberByID);
        memberDetailFormDTO.setClassCodes(classCodeDTOS);

        return memberDetailFormDTO;
    }

    public List<ClassCodeDTO> userBoardListById(String member_id) {

        return dao.userBoardListById(member_id);
    }

    public List<ClassBoardTypeDTO> findClassBoardTypeByID(String class_id) {
        log.info(" service " + class_id);
        return dao.findClassBoardTypeByID(class_id);
    }
}
