package com.turkcell.lms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private int id;
    private String name;
    private String surname;
    private int memberNumber;
    private LocalDate startDate;
}