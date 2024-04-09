package com.turkcell.lms.services.dtos.requests.member;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberRequest {
    private String password;
    private String email;
}
