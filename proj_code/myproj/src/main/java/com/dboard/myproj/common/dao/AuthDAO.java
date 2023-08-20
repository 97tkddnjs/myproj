package com.dboard.myproj.common.dao;

import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.dto.MemberFormDTO;
import com.dboard.myproj.data.entity.ClassCodeVO;
import com.dboard.myproj.data.entity.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author  : lsw
 *
 * member 조회
 * member 삽입 <- 기본 default grade 는 user로
 * member 여부 확인 <- email로 <- 조회 되는 것 확인함
 *
 *
 * */
@Mapper
public interface AuthDAO {


    MemberVO memberRetrievalById(MemberVO memberVo);

    void memberSave(MemberVO memberVo);
    //MemberFormDto dto
    //parameterType="com.dboard.myproj.common.dto.MemberFormDto"
//    @Select("")
    MemberVO memberRetrieval();


    @Select("SELECT * FROM member")
    MemberVO memberRetrieval2();

    List<ClassCodeVO> findClassCodes();

    void saveCourseReg(ClassCodeDTO classCode);
}
