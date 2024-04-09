package com.turkcell.lms.services.dtos.requests.staff;

import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddStaffRequest {
    private String name;
    private String surname;
    @Email(message = "Invalid email format")
    private String email;
    private String password;
    private String role;
    private int staffNumber;
}
