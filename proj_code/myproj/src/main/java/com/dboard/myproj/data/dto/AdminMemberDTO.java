package com.dboard.myproj.data.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminMemberDTO {

    Long member_id;

    String email;

    String password;

    String member_nm;

    String party;

    Long grade_id;

    Long restrict_YN;

}
