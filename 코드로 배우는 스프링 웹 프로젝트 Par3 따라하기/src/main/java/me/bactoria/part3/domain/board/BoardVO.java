package me.bactoria.part3.domain.board;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BoardVO {

    private Long bno;
    private String title;
    private String content;
    private String writer;
    private LocalDate regdate;
    private LocalDate updateDate;
}
