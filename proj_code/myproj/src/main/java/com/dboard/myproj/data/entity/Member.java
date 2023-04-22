package com.dboard.myproj.data.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    Long member_id;

    String email;

    //@NotEmpty
    String password;

    //@NotNull
    String member_name;

    String address;

    String party;

    String allias;

    String groupt_id;

    int grade_id;

}
