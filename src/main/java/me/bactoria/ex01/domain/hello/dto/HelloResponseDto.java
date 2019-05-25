package me.bactoria.ex01.domain.hello.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HelloResponseDto {
    private String message;
    private LocalDate date;
}
