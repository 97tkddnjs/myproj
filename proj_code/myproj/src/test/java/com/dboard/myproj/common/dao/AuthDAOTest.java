package com.dboard.myproj.common.dao;

import com.dboard.myproj.config.page.Pagination;
import com.dboard.myproj.config.page.PagingResponse;
import com.dboard.myproj.config.page.SearchDto;
import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.data.dto.MemberFormDto;
import com.dboard.myproj.data.entity.Member;
import com.dboard.myproj.mysite.admin.dao.AdminDAO;
import com.dboard.myproj.mysite.admin.service.AdminService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * https://www.inflearn.com/questions/206956/%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%97%90%EB%9F%AC-%EB%AC%B8%EC%9D%98-execution-failed-for-task-x27-test-x27
 *
 *
 * */
@SpringBootTest
@Transactional
//@TestPropertySource(locations = "classpath:application.properties")
class AuthDAOTest {

    @Autowired
    AuthDAO dao;

    @Autowired
    AdminDAO adminDAO;


    @Autowired
    AdminService service;
    @Test
    @DisplayName("bb")
    void memberSave() {
        MemberFormDto dto = new MemberFormDto();
        dto.setEmail("test@a.com");

        Member member = dao.memberRetrieval();
//        Member member = dao.memberRetrieval2();
        System.out.println("member = " + member);
    }

    @Test
    @DisplayName("aa")
    void memberRetrieval() {

        MemberFormDto dto = new MemberFormDto();
        dto.setEmail("test@a.com");

//        Member member = dao.memberRetrieval();
        Member member = dao.memberRetrieval2();
        System.out.println("member = " + member);

    }

    @Test
    @DisplayName("bb")
    void test1(){

        SearchDto params = new SearchDto();
        int count = adminDAO.countMember(params);
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<AdminMemberDTO> allUserMember = adminDAO.findAllUserMember(params);
        allUserMember.stream().forEach(
                member_admin -> System.out.println("member_admin = " + member_admin)
        );

    }


    @Test
    void test2() {

        String email = "test@a.com";
        AdminMemberDTO userMemberByEmail = adminDAO.findUserMemberByEmail(email);
        System.out.println("userMemberByEmail = " + userMemberByEmail);
        Boolean d = null;
        if(d==null || d==false){
            System.out.println("d = " + d);
        }
        //Boolean aBoolean = adminDAO.isRestrict(email);
        //System.out.println("aBoolean = " + aBoolean);
    }

    @Test
    void testUser() {

        for(int i = 1; i <=15;i++){
            MemberFormDto dto = new MemberFormDto();
            String name = "testuser"+i;
            String email = name +"@test.com";
            dto.setEmail(email);
            dto.setPassword("1234");
            dto.setMember_name(name);
            dto.setAllias(name);
            dto.setGroup_id(1);
//            System.out.println("email = " + email);
            dao.memberSave(dto);
        }



    }

    @Test
    void test5() {


        String name = "testuser1";
        SearchDto params =new SearchDto();

        PagingResponse<AdminMemberDTO> adminMemberDTOPagingResponse = service.searchMemberName(name, params);
        List<AdminMemberDTO> list = adminMemberDTOPagingResponse.getList();
        list.stream().forEach(
                member_admin -> System.out.println("member_admin = " + member_admin)
        );
        System.out.println("list.size() = " + list.size());

    }


}