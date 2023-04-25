package com.dboard.myproj.data.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty
    private String id; // pk 사용자 id

    @NotEmpty
    private String pass; // 사용자 비번
}