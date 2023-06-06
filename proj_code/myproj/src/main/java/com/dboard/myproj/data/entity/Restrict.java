package com.dboard.myproj.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Restrict {

    Long restrict_id;

    Long member_id;

    String email;

    Long restrict_cnt;

    Boolean restrict_show;
}
