package com.dboard.myproj.data.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Restrict {

    Long restrict_id;

    Long member_id;

    String email;

    Long restrict_cnt;

    Boolean restrict_show;
}
