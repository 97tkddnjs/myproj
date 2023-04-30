package com.dboard.myproj.mysite.admin.dao;


import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author  : 이상원
 *
 *  member <- 모두 조회
 *  member detail 모든 정보 보여주면서
 *  group 정보도 올 detatil에서
 * */

@Mapper
public interface AdminDAO {

    List<AdminMemberDTO> findAllUserMember(SearchDto params);

    int countMember(SearchDto params);
}
