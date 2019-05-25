package me.bactoria.ex01.domain.hello.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class HelloRequestDto {
    private String message;
    private long id;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
}
