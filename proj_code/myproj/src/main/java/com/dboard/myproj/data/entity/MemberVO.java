package com.dboard.myproj.data.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class MemberVO {

    String member_id;

    String email;

    //@NotEmpty
    String password;

    //@NotNull
    String member_nm;

    String phone_num;

    String party;

    int grade_id;

    LocalDateTime reg_dt;

}
