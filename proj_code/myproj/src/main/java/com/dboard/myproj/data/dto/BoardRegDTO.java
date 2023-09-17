package com.dboard.myproj.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class BoardRegDTO {


    String cb_type;

    String title;

    String member_id;

    String cnts;

    MultipartFile addFile;

}
