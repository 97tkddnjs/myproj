package com.dboard.myproj.mysite.admin.service;

import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.mysite.admin.dao.AdminDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 * */

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminDAO dao;

    @Transactional
    public List<AdminMemberDTO> findAllUserMember(){

        return dao.findAllUserMember();
    }


}
