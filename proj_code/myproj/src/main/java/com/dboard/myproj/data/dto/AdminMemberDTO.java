package com.dboard.myproj.data.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AdminMemberDTO {

    String member_id;

    String email;

    String password;

    String member_nm;

    String party;

    Long grade_id;

    LocalDateTime reg_dt;

    Long restrict;

}
