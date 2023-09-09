package com.dboard.myproj.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class MemberDetailFormDTO {

    private AdminMemberDTO member;

    private List<ClassCodeDTO> classCodes;
}
