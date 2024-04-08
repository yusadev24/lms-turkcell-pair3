package com.turkcell.lms.services.dtos.requests.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private int memberNumber;
}
