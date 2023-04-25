package com.dboard.myproj.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberFormDto {

    //@NotNull
    String email;

    //@NotEmpty
    String password;

    //@NotNull
    String member_name;

    String address;

    String party;

    String allias;

    Integer groupt_id;
}
