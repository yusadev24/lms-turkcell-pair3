package com.turkcell.lms.services.dtos.requests.member;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberRequest {
    private String password;
    @Email(message = "Invalid email format")
    private String email;
}
