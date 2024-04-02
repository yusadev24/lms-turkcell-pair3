package com.turkcell.lms.services.dtos.requests.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private int memberNumber;
}
