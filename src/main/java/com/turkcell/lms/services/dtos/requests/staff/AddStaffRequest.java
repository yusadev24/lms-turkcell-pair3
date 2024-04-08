package com.turkcell.lms.services.dtos.requests.staff;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddStaffRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    private int staffNumber;
}
