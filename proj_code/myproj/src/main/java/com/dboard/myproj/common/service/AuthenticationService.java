package com.dboard.myproj.common.service;

import com.dboard.myproj.common.dao.AuthDAO;
import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.dto.MemberFormDTO;
import com.dboard.myproj.data.entity.ClassCodeVO;
import com.dboard.myproj.data.entity.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthDAO authDAO;


    @Transactional
    public boolean signUp(MemberFormDTO dto){

        MemberVO member = authDAO.memberRetrievalByEmail(dto);
        if (member == null) {
            authDAO.memberSave(dto);
            return  true;
        }else{
            return false;
        }
    }

    @Transactional
    public MemberVO login(MemberFormDTO dto) {

        MemberVO member = authDAO.memberRetrievalByEmail(dto);

        if(member.getPassword().equals(dto.getPassword()) ){
            return member;
        }else{
            return null;
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
