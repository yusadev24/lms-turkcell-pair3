package com.turkcell.lms.services.dtos.requests.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddStaffRequest {
    private String name;
    private String surname;
    private String role;
    private String email;
    private String password;
    private int staffNumber;
}
