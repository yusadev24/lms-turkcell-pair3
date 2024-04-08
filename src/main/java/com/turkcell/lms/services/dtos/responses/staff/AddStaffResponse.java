package com.turkcell.lms.services.dtos.responses.staff;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStaffResponse {
    private int id;
    private String name;
    private String surname;
    private String role;
    private String email;
    private String password;
    private int staffNumber;
}
