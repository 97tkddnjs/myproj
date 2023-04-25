package com.dboard.myproj.common.dao;

import com.dboard.myproj.data.dto.MemberFormDto;
import com.dboard.myproj.data.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
}