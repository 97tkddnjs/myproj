package com.dboard.myproj.mysite.user.service;


import com.dboard.myproj.config.page.Pagination;
import com.dboard.myproj.config.page.PagingResponse;
import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.*;
import com.dboard.myproj.data.entity.BoardDetailVO;
import com.dboard.myproj.mysite.user.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
//@RequiredArgsConstructor
public class UserService {

    private final UserDAO dao;

    @Autowired
    UserService(UserDAO userDAO) {
        this.dao = userDAO;
    }


    @Value("${file.dir}")
    private String fileDir;

    public MemberDetailFormDTO findUserDetailByID(String member_id) {

        AdminMemberDTO userMemberByID = dao.findUserMemberByID(member_id);
        List<ClassCodeDTO> classCodeDTOS =  dao.findAllClassCode(member_id);

        MemberDetailFormDTO memberDetailFormDTO = new MemberDetailFormDTO();
        memberDetailFormDTO.setMember(userMemberByID);
        memberDetailFormDTO.setClassCodes(classCodeDTOS);

        return memberDetailFormDTO;
    }

    public List<ClassCodeDTO> userBoardListById(String member_id) {

        return dao.userBoardListById(member_id);
    }

    public List<ClassBoardTypeDTO> findClassBoardTypeByID(String class_id) {
        log.info(" service " + class_id);
        return dao.findClassBoardTypeByID(class_id);
    }

    public PagingResponse<BoardDetailVO> findAllBoardDetail(String cb_type ,final SearchDto params) {

        int count  = dao.countBoardDetail(cb_type,params);

        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        // param 에 pagination 정보 주입
        params.setPagination(pagination);


        List<BoardDetailVO> allBoardDetail = dao.findAllBoardDetail(cb_type, params);


        return  new PagingResponse<>(allBoardDetail,pagination);
    }

    public void savedBoard(BoardRegDTO boardRegDTO) throws  IOException{

        String path = savedFile(boardRegDTO.getAddFile());

        BoardDetailVO boardDetailVO = new BoardDetailVO();
        LocalDateTime curtime = LocalDateTime.now();

        boardDetailVO.setBd_dt(curtime);
        boardDetailVO.setContents(boardRegDTO.getCnts());
        boardDetailVO.setTitle(boardRegDTO.getTitle());
        boardDetailVO.setMember_id(boardRegDTO.getMember_id());
        boardDetailVO.setCb_type(boardRegDTO.getCb_type());
        boardDetailVO.setFile_path(path);

        log.info("===file ok ==== "+path);
        dao.savedBoard(boardDetailVO);

    }

    public String savedFile(MultipartFile files) throws IOException{

        if (files.isEmpty()) {
            return null;
        }
        try {

            // 원래 파일 이름 추출
            String origName = files.getOriginalFilename();

            // 파일 이름으로 쓸 uuid 생성
            String uuid = UUID.randomUUID().toString();

            // 확장자 추출(ex : .png)
            String extension = origName.substring(origName.lastIndexOf("."));

            // uuid와 확장자 결합
            String savedName = uuid + extension;

            // 파일을 불러올 때 사용할 파일 경로
            String savedPath = fileDir + savedName;

            files.transferTo(new File(savedPath));

            return savedPath;
        }catch (Exception e){
            return null;
        }

    }
}
