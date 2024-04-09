package com.turkcell.lms.services.dtos.requests.member;

import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberRequest {
    private String name;
    private String surname;
    @Email(message = "Invalid email format")
    private String email;
    private String password;
    private int memberNumber;
}
