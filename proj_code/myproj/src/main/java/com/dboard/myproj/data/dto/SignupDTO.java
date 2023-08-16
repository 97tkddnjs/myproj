package com.dboard.myproj.data.dto;

import lombok.Data;

import java.util.List;

@Data
public class SignupDTO {

    private MemberFormDTO member;

    private List<ClassCodeDTO> classCodes;
}
