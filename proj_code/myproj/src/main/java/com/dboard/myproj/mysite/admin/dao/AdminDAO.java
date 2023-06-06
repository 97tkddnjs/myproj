package com.dboard.myproj.mysite.admin.dao;


import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.entity.Group;
import com.dboard.myproj.data.entity.Member;
import com.dboard.myproj.data.entity.Restrict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
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

    AdminMemberDTO findUserMemberByEmail(String email);

    List<Group> findAllGroup();

    int updateMemberByEmail(AdminMemberDTO member);

    Boolean isRestrict(String email);

    int updateRestrict(AdminMemberDTO member);

    int updateNotRestrict(AdminMemberDTO member);

    Restrict findRestrictByEmail(AdminMemberDTO member);

    void restrictMemberSave(AdminMemberDTO member);

    int cntSearchMemberName(HashMap<String, Object> map);
    List<AdminMemberDTO>  searchMemberName(HashMap<String, Object> map);

    List<AdminMemberDTO>  searchRestrictMemberName(String name, final SearchDto params);



    //List<AdminMemberDTO>  searchGroupMemberName(String name,final SearchDto params);


}
