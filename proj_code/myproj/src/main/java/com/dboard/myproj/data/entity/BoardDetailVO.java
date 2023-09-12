package com.dboard.myproj.data.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class BoardDetailVO {

    int bd_id;

    String title;

    String member_id;

    String contents;

    String file_path;

    String cb_type;

    Boolean bd_show;

    LocalDateTime bd_dt;

}
