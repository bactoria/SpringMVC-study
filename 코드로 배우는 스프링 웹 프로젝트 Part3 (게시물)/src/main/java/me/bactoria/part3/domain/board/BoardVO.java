package me.bactoria.part3.domain.board;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BoardVO {

    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updateDate;
}
