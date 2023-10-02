package com.dboard.myproj.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UpdateBoardDTO {

    private int class_id;

    private List<BoardTypeDTO> boardType;
}
