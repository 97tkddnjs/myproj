package com.dboard.myproj.mysite.admin.service;

import com.dboard.myproj.config.page.Pagination;
import com.dboard.myproj.config.page.PagingResponse;
import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.entity.Group;
import com.dboard.myproj.mysite.admin.dao.AdminDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * */

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminDAO dao;

    @Transactional
    public PagingResponse<AdminMemberDTO> findAllUserMember(final SearchDto params){

        int count  = dao.countMember(params);

        Map<String, Object> mapping = new HashMap<>();
        if (count < 1) {

        }

        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        // param 에 pagination 정보 주입
        params.setPagination(pagination);

        List<AdminMemberDTO> allUserMember = dao.findAllUserMember(params);

        return new PagingResponse<>(allUserMember, pagination);
    }


    @Transactional
    public AdminMemberDTO findUserMemberByEmail(String email) {

        return dao.findUserMemberByEmail(email);
    }


    public List<Group> findAllGroup() {

        return dao.findAllGroup();
    }

    @Transactional
    public int updateMemberByEmail(AdminMemberDTO member) {
            return dao.updateMemberByEmail(member);
    }
}
