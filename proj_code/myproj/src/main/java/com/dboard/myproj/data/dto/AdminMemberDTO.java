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

    String member_name;

    String address;

    String party;

    String allias;

    Long grade_id;

    String grade_type;

    String group_type;

    Long restrict_id;

    Boolean restrict_show;

}
