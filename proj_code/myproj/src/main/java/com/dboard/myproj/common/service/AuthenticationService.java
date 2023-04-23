package com.dboard.myproj.common.service;

import com.dboard.myproj.common.dao.AuthDAO;
import com.dboard.myproj.common.dto.LoginForm;
import com.dboard.myproj.common.dto.MemberFormDto;
import com.dboard.myproj.config.SessionConst;
import com.dboard.myproj.data.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthDAO authDAO;


    @Transactional
    public boolean signUp(MemberFormDto dto){

        Member member = authDAO.memberRetrievalByEmail(dto);
        if (member == null) {
            authDAO.memberSave(dto);
            return  true;
        }else{
            return false;
        }
    }

    @Transactional
    public Member login(MemberFormDto dto) {

        Member member = authDAO.memberRetrievalByEmail(dto);

        if(member.getPassword().equals(dto.getPassword()) ){
            return member;
        }else{
            return null;
        }
    }
}
