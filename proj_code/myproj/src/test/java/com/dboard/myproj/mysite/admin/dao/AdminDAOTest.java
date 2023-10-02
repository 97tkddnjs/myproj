package com.dboard.myproj.mysite.admin.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class AdminDAOTest {

    @Autowired
    AdminDAO dao;

    @Test
    void findRestrictMemberById() {
        String member_id = "2017305056";
        Integer restrictMemberById = dao.findRestrictMemberById(member_id);
        System.out.println("restrictMemberById = " + restrictMemberById);
    }

    @Test
    void updateRestrictMember() {

        BigDecimal bigDecimal = new BigDecimal(BigInteger.ZERO);


    }

    @Test
    void saveRestrictMemberById() {
    }
}