package com.turkcell.lms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
    private int id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private int nationalId;
    private String role;
    private int staffNumber;
}