package com.dboard.myproj.common.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberFormDto {

    @NotEmpty
    String email;

    @NotEmpty
    String password;

    @NotNull
    String member_name;

    String address;

    String party;

    String allias;

    String group_id;
}
