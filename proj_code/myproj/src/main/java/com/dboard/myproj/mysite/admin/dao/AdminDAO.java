package com.dboard.myproj.mysite.admin.dao;


import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.AdminBoardDTO;
import com.dboard.myproj.data.dto.AdminMemberDTO;

import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.entity.ClassCodeVO;
import com.dboard.myproj.data.entity.Restrict;
import org.apache.ibatis.annotations.Mapper;

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

    AdminMemberDTO findUserMemberByID(String memberID);

    int countClassCode(SearchDto params);

    List<ClassCodeVO> findAllClassCode(SearchDto params);

    int saveClassCode(ClassCodeDTO classCodeDTO);

    int saveClassBoardType(ClassCodeDTO classCodeDTO);

    ClassCodeVO findClassCodeById(String classId);

    List<ClassCodeDTO> findCourseRegistrationByMemberID(String memberID);

    int updateClassCodeById(ClassCodeDTO classCodeDTO);

    List<AdminBoardDTO> findAllBoard(SearchDto params);


    //List<AdminMemberDTO>  searchGroupMemberName(String name,final SearchDto params);


}
