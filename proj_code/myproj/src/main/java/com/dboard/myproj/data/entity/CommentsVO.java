package com.dboard.myproj.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentsVO {

    int com_id;

    String comments;

    LocalDateTime com_dt;

    int bd_id;

    boolean com_show;

    String member_id;

}
