package com.dboard.myproj.mysite.admin.service;

import com.dboard.myproj.config.page.Pagination;
import com.dboard.myproj.config.page.PagingResponse;
import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.AdminBoardDTO;
import com.dboard.myproj.data.dto.AdminMemberDTO;

import com.dboard.myproj.data.dto.ClassCodeDTO;
import com.dboard.myproj.data.dto.MemberDetailFormDTO;
import com.dboard.myproj.data.entity.ClassCodeVO;
import com.dboard.myproj.data.entity.Restrict;
import com.dboard.myproj.mysite.admin.dao.AdminDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 *
 * */


@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminDAO dao;

    @Transactional
    public PagingResponse<AdminMemberDTO> findAllUserMember(final SearchDto params){

        int count  = dao.countMember(params);



        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        // param 에 pagination 정보 주입
        params.setPagination(pagination);

        List<AdminMemberDTO> allUserMember = dao.findAllUserMember(params);

        return new PagingResponse<>(allUserMember, pagination);
    }

    @Transactional
    public PagingResponse<ClassCodeVO> findAllClass(SearchDto params) {

        int count = dao.countClassCode(params);

        Pagination pagination = new Pagination(count, params);

        List<ClassCodeVO> allClassCodes =  dao.findAllClassCode(params);

        return new PagingResponse<>(allClassCodes, pagination);

    }

    @Transactional
    public int saveClassCode(ClassCodeDTO classCodeDTO) {

        dao.saveClassCode(classCodeDTO);

        return dao.saveClassBoardType(classCodeDTO);


    }

    public ClassCodeDTO findClassCodeById(String classId) {

        ClassCodeVO classCodeVO = dao.findClassCodeById(classId);
        ClassCodeDTO classCodeDTO = new ClassCodeDTO();

        classCodeDTO.setClass_id(classCodeVO.getClass_id());
        classCodeDTO.setClass_nm(classCodeVO.getClass_nm());
        classCodeDTO.setClass_ymd(classCodeVO.getClass_ymd());
        classCodeDTO.setDel_yn(classCodeVO.getDel_yn());

        return classCodeDTO;
    }

    public int updateClassCodeById(ClassCodeDTO classCodeDTO) {

        return dao.updateClassCodeById(classCodeDTO);
    }

    public List<AdminBoardDTO> findAllBoard(SearchDto params) {

        return  dao.findAllBoard(params);

    }

    public MemberDetailFormDTO findMemberDetailById(String memberId) {

        AdminMemberDTO userMemberByID = dao.findUserMemberByID(memberId);
        List<ClassCodeDTO> courseRegistrationByMemberID = dao.findCourseRegistrationByMemberID(memberId);

        MemberDetailFormDTO memberDetailFormDTO = new MemberDetailFormDTO();

        memberDetailFormDTO.setMember(userMemberByID);
        memberDetailFormDTO.setClassCodes(courseRegistrationByMemberID);

        return  memberDetailFormDTO;

    }

//
//    @Transactional
//    public AdminMemberDTO findUserMemberByEmail(String email) {
//
//        return dao.findUserMemberByEmail(email);
//    }
//
//
//    public List<Group> findAllGroup() {
//
//        return dao.findAllGroup();
//    }
//
//
//    // logic 바꾸기
//    @Transactional
//    public int updateMemberByEmail(AdminMemberDTO member) {
//
//
//        log.info("res  "+ member.getRestrict_show());
//        // 만약 null column 이 존재하지 않는 것임 restrict 부터
//        Restrict restrict = dao.findRestrictByEmail(member);
//
//        log.info("restrict "+restrict);
//
//        if(member.getRestrict_show()==null){
//            // 제한 안걸기
//            // 데이터가 있었어
//            log.info("res  nonono");
//            System.out.println("res bbb");
//            if(restrict !=null && restrict.getRestrict_show()==true){
//                log.info("res false -> true +=1");
//                dao.updateNotRestrict(member);
//            }
//
//        }
//        else if(member.getRestrict_show()==true){
//            // 제한 걸거야
//            log.info("sssss");
//            // 데이터 없어 -> 생성
//            if(restrict==null){
//                log.info("ins restrict");
//                dao.restrictMemberSave(member);
//
//            }else{ // 데이터 있어 근데 false -> 제한걸어
//
//                if(restrict.getRestrict_show()==null){
//
//                    log.info("already res false => true");
//                    dao.updateRestrict(member);
//
//                }
//            }
//
//        }else{
//            System.out.println("res ccc");
//            log.info("dddd");
//        }
//
//        log.info("ssasdfasdfa");
//        return dao.updateMemberByEmail(member);
//    }
//
//    @Transactional
//    public PagingResponse<AdminMemberDTO>  searchMemberName(String name,final SearchDto params) {
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", name);
//        map.put("params", params);
//
//        int count = dao.cntSearchMemberName(map);
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        List<AdminMemberDTO> adminMemberDTOS = dao.searchMemberName(map);
//
//        return new PagingResponse<>(adminMemberDTOS, pagination);
//    }
//
//    @Transactional
//    public PagingResponse<AdminMemberDTO>  searchRestrictMemberName(String name, final SearchDto params) {
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", name);
//        map.put("params", params);
//
//        return null;
//    }
//
//    @Transactional
//    public PagingResponse<AdminMemberDTO>  searchGroupMemberName(String name,final SearchDto params) {
//
//        return null;
//    }
}
