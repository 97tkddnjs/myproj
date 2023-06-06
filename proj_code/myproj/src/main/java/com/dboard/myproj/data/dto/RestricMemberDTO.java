package com.dboard.myproj.data.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestricMemberDTO {

    Long restrict_id;

    Long member_id;

    String email;

    Long restrict_cnt;

    String password;

    String member_name;

    String address;

    String party;

    String alizs;

    Long grade_id;

    Long group_id;

}
