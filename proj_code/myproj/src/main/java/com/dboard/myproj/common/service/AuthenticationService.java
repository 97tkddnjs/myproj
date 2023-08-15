package com.dboard.myproj.common.service;

import com.dboard.myproj.common.dao.AuthDAO;
import com.dboard.myproj.data.dto.LoginForm;
import com.dboard.myproj.data.dto.MemberFormDto;
import com.dboard.myproj.data.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if(member.getPassword().equals(dto.getPass()) ){
            return member;
        }else{
            return null;
        }
    }
}
