package com.dboard.myproj.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberFormDto {

    //@NotNull
    String member_id;

    String email ;
    //@NotEmpty
    String pass;

    //@NotNull
    String member_nm;

    String phone_num;

    String party;
}
