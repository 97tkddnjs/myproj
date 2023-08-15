package com.dboard.myproj.data.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class Member {

    String member_id;

    String email;

    //@NotEmpty
    String password;

    //@NotNull
    String member_nm;

    String phone_num;

    String party;

    int grade_id;

    Date date;

}
