package com.dboard.myproj.common.dao;

import com.dboard.myproj.data.dto.MemberFormDto;
import com.dboard.myproj.data.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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


    Member memberRetrievalByEmail(MemberFormDto memberDto);

    void memberSave(MemberFormDto memberDto);
    //MemberFormDto dto
    //parameterType="com.dboard.myproj.common.dto.MemberFormDto"
//    @Select("")
    Member memberRetrieval();



    @Select("SELECT * FROM member")
    Member memberRetrieval2();

}
