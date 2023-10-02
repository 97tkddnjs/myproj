package com.dboard.myproj.mysite.admin.dao;


import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.*;

import com.dboard.myproj.data.entity.BoardTypeVO;
import com.dboard.myproj.data.entity.ClassCodeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    int saveClassBoardTypeDefault(ClassCodeDTO classCodeDTO);

    ClassCodeVO findClassCodeById(String classId);

    List<ClassCodeDTO> findCourseRegistrationByMemberID(String memberID);

    int updateClassCodeById(ClassCodeDTO classCodeDTO);

    List<AdminBoardDTO> findAllBoard(SearchDto params);

    int findRestrictMemberById(String member_id);

    int updateRestrictMember(AdminMemberDTO memberDTO);

    int saveRestrictMemberById(String member_id);

    List<BoardTypeVO> findAllBoardType();

    List<BoardTypeDTO> findRegClassByClassId(int classId);

    int saveBoardType(String boardnm);

    List<ClassBoardTypeDTO> findClassBoardTypeByClassId(String classId);

    void updateClassBoardTypeById(Map<String,Object> data);

    void saveClassBoardTypeById(Map<String,Object> data);

    List<ClassBoardTypeDTO> countClassBoardTypeByID(Map<String, Object> param);


    //List<AdminMemberDTO>  searchGroupMemberName(String name,final SearchDto params);


}
