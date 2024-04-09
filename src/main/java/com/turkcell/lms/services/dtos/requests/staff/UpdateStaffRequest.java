package com.turkcell.lms.services.dtos.requests.staff;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStaffRequest {
    private String password;
    @Email(message = "Invalid email format")
    private String email;
    private String role;
}
