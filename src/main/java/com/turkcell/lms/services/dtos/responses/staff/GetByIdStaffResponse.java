package com.turkcell.lms.services.dtos.responses.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdStaffResponse {
    private int id;
    private String name;
    private String surname;
    private String role;
    private String email;
    private String password;
    private int staffNumber;
}
