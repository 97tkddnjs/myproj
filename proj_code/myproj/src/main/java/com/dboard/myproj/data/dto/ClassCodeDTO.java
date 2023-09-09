package com.dboard.myproj.data.dto;


import lombok.Data;

@Data
public class ClassCodeDTO {

    String member_id;

    int class_id;

    String class_nm;

    String class_ymd;

    String del_yn;

    boolean registerClassYN;

}
