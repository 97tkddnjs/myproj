package com.dboard.myproj.mysite.user.dao;

import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.dto.ClassBoardTypeDTO;
import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.entity.BoardDetailVO;
import com.dboard.myproj.data.entity.CommentsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDAO {


    AdminMemberDTO findUserMemberByID(String member_id);

    List<ClassCodeDTO> findAllClassCode(String member_id);

    List<ClassCodeDTO> userBoardListById(String member_id);

    List<ClassBoardTypeDTO> findClassBoardTypeByID(String class_id);

    List<BoardDetailVO> findAllBoardDetail(@Param("cb_type") String cb_type ,@Param("params") final SearchDto params);

    int countBoardDetail(@Param("cb_type")String cb_type, @Param("params") final  SearchDto params);

    int savedBoard(BoardDetailVO boardDetailVO);

    BoardDetailVO findBoardDetailById(int bd_id);

    int saveComment(CommentsVO comment);

    List<CommentsVO> findAllCommentsByBd(int bd_id);

    List<String> countCourseRegistrationById(ClassCodeDTO classCodeDTO);

    void updateMemberDetail(AdminMemberDTO member);

    void deleteCourseRegistrationByID(String id);

    void saveCourseRegistration(ClassCodeDTO classCodeDTO);

    int deleteBoardFilePathById(int bd_id);

    int updateBoardDetail(BoardDetailVO boardDetailVO);

    int deleteBoardById(int bd_id);

    int deleteCommentById(int com_id);
}
