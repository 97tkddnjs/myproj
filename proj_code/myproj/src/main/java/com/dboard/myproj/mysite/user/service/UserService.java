package com.dboard.myproj.mysite.user.service;


import com.dboard.myproj.config.page.Pagination;
import com.dboard.myproj.config.page.PagingResponse;
import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.*;
import com.dboard.myproj.data.entity.BoardDetailVO;
import com.dboard.myproj.data.entity.CommentsVO;
import com.dboard.myproj.mysite.user.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public Boolean savedBoard(BoardRegDTO boardRegDTO) throws  IOException{

        String path = savedFilePath(boardRegDTO.getAddFile());

        BoardDetailVO boardDetailVO = new BoardDetailVO();
        LocalDateTime curtime = LocalDateTime.now();

        boardDetailVO.setBd_dt(curtime);
        boardDetailVO.setContents(boardRegDTO.getCnts());
        boardDetailVO.setTitle(boardRegDTO.getTitle());
        boardDetailVO.setMember_id(boardRegDTO.getMember_id());
        boardDetailVO.setCb_type(boardRegDTO.getCb_type());
        boardDetailVO.setFile_path(path);

        log.info("===file ok ==== "+path);
        int flag = dao.savedBoard(boardDetailVO);
        if(flag >0){
            if(path != null) {
                savedFile(boardRegDTO.getAddFile(), path);
            }
            return true;
        }

        return false;

    }
    public String savedFilePath(MultipartFile files) throws IOException{

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
            String savedPath =  savedName;

            return savedPath;

        }catch (Exception e){
            return null;
        }
    }
    public String savedFile(MultipartFile files, String savedPath) throws IOException{

        if (files.isEmpty()) {
            return null;
        }
        try {

            files.transferTo(new File(fileDir+savedPath));

            return savedPath;
        }catch (Exception e){
            return null;
        }

    }
    public UrlResource readFileAsResource(String addFilePath) throws IOException {

//        Path filePath = Paths.get("<file_path_string>");
        UrlResource resource = new UrlResource("file:"+fileDir+addFilePath.toString());
//        String fileName = "<file_name_string>";
//        log.info("Success download input excel file : " + filePath);
        return resource;
    }


    public BoardDetailVO findBoardDetailById(int bd_id) {

        return dao.findBoardDetailById(bd_id);
    }

    public int saveComment(CommentsVO comment) {
        return dao.saveComment(comment);
    }

    public List<CommentsVO> findAllCommentsByBd(int bd_id) {

        return dao.findAllCommentsByBd(bd_id);
    }

    public int updateUserInfo(MemberDetailFormDTO memberDetailFormDTO) {

        AdminMemberDTO member = memberDetailFormDTO.getMember();
        List<ClassCodeDTO> classCodes = memberDetailFormDTO.getClassCodes();


        // member 먼저 update 하고
        dao.updateMemberDetail(member);

        // i 중 course_registration 부분에 없으면 save , 있으면 delete

        for (ClassCodeDTO classCodeDTO: classCodes ) {
            List<String> data = dao.countCourseRegistrationById(classCodeDTO);
            // count ==1 이미 있는 데 존재 하지 않어야 해~
            if(!classCodeDTO.isRegisterClassYN() && data.size()==1){

                String id = data.get(0);
                //delete
                dao.deleteCourseRegistrationByID(id);

            }

            // 없는 데 존재해야 해~
            if(classCodeDTO.isRegisterClassYN() && data.size()==0){
                // save

                dao.saveCourseRegistration(classCodeDTO);
            }
        }
        return 1;
    }

    @Transactional
    public Boolean updateBoard(BoardRegDTO boardRegDTO,int bd_id) throws IOException {

        // 찾아서 정보를 가져와~

        BoardDetailVO boardDetailVO = dao.findBoardDetailById(bd_id);
        boardDetailVO.setContents(boardRegDTO.getCnts());


        // file 도 추가 되었어 ~ 그럼 file 도 업데이트
        MultipartFile fileInfo = boardRegDTO.getAddFile();
        String savedFilePath =null;
        if(!fileInfo.isEmpty()){

            savedFilePath = savedFilePath(fileInfo);
            boardDetailVO.setFile_path(savedFilePath);

        }
        //update
        int flag= dao.updateBoardDetail(boardDetailVO);

        savedFile(fileInfo, savedFilePath);

        if(flag>0){
            return true;
        }

        return false;
    }

    public int deleteFilePathById(int bd_id) {

        return dao.deleteBoardFilePathById(bd_id);
    }

    public int deleteBoardById(int bd_id) {
        return dao.deleteBoardById(bd_id);
    }

    @Transactional
    public int deleteCommentById(int com_id) {

        return dao.deleteCommentById(com_id);
    }
}
