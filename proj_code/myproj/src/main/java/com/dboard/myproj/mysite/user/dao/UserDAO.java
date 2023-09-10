package com.dboard.myproj.mysite.user.dao;

import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.dto.ClassBoardTypeDTO;
import com.dboard.myproj.data.dto.ClassCodeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {


    AdminMemberDTO findUserMemberByID(String member_id);

    List<ClassCodeDTO> findAllClassCode(String member_id);

    List<ClassCodeDTO> userBoardListById(String member_id);

    List<ClassBoardTypeDTO> findClassBoardTypeByID(String class_id);
}
