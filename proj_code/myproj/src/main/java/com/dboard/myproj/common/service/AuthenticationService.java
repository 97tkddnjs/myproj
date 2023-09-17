package com.dboard.myproj.common.service;

import com.dboard.myproj.common.dao.AuthDAO;
import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.dto.MemberFormDTO;
import com.dboard.myproj.data.dto.SignupDTO;
import com.dboard.myproj.data.entity.ClassCodeVO;
import com.dboard.myproj.data.entity.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthDAO authDAO;


    @Transactional
    public boolean signUp(SignupDTO signupDTO){

        LocalDateTime now = LocalDateTime.now();

        MemberFormDTO memberFormDTO = signupDTO.getMember();
        List<ClassCodeDTO> classCodes = signupDTO.getClassCodes();


        MemberVO memberVO = MemberVO.builder()
                        .member_id(memberFormDTO.getMember_id())
                        .email(memberFormDTO.getEmail())
                        .member_nm(memberFormDTO.getMember_nm())
                .password(memberFormDTO.getPassword())
                .member_nm(memberFormDTO.getMember_nm())
                .phone_num(memberFormDTO.getPhone_num())
                .reg_dt(now)
                .build();



        MemberVO member
                = authDAO.memberRetrievalById(memberVO);

        if (member == null) {
            authDAO.memberSave(memberVO);

            for(ClassCodeDTO classCode :classCodes){
                if(classCode.isRegisterClassYN()==true){
                    classCode.setMember_id(memberVO.getMember_id());
                    authDAO.saveCourseReg(classCode);
                }

            }

            return  true;
        }else{
            return false;
        }
    }

    @Transactional
    public MemberVO login(MemberFormDTO memberFormDTO) {

        MemberVO memberVO = MemberVO.builder()
                .member_id(memberFormDTO.getMember_id())
                .email(memberFormDTO.getEmail())
                .member_nm(memberFormDTO.getMember_nm())
                .password(memberFormDTO.getPassword())
                .member_nm(memberFormDTO.getMember_nm())
                .phone_num(memberFormDTO.getPhone_num())
                .build();
        log.info(" member VO  : {}",memberVO);
        MemberVO member = authDAO.memberRetrievalById(memberVO);

        if(member==null){
            return null;
        }
        else{
            if(member.getPassword().equals(memberVO.getPassword()) ) {
                return member;
            }else{
                return null;
            }
        }
    }

    public List<ClassCodeDTO> findClassCodes() {

        List<ClassCodeVO> classCodes = authDAO.findClassCodes();


        List<ClassCodeDTO> classCodeDTOList = new ArrayList<>();

        for (ClassCodeVO classCodeVO : classCodes) {
            ClassCodeDTO classCodeDTO = new ClassCodeDTO();

            classCodeDTO.setClass_id(classCodeVO.getClass_id());
            classCodeDTO.setClass_nm(classCodeVO.getClass_nm());
            classCodeDTO.setClass_ymd(classCodeVO.getClass_ymd());
            classCodeDTO.setRegisterClassYN(false);

            classCodeDTOList.add(classCodeDTO);
        }

        return classCodeDTOList;
    }
}
