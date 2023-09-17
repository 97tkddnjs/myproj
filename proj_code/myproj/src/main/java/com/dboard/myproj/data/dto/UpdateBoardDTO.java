package com.dboard.myproj.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class UpdateBoardDTO {

    private String class_id;

    private List<BoardTypeDTO> boardType;
}
