package com.dboard.myproj.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardTypeDTO  {
//implements Comparable<BoardTypeDTO>

    int board_id;

    String board_nm;

    int register;


//    @Override
//    public int compareTo(BoardTypeDTO o) {
//        if(board_id > o.getBoard_id()){
//            return 1;
//        }else if(board_id < o.getBoard_id()){
//            return -1;
//        }
//        return 0;
//    }
}
