package com.dboard.myproj.data.dto;

import lombok.Data;

@Data
public class MemberFormDTO {

    //@NotNull
    String member_id;

    String email ;
    //@NotEmpty
    String password;

    //@NotNull
    String member_nm;

    String phone_num;

    String party;
}
