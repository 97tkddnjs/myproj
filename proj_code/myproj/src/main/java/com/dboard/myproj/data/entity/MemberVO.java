package com.dboard.myproj.data.entity;


import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
