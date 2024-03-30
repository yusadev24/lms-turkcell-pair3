package com.turkcell.lms.dtos.responses.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberResponse {
    private int id;
    private String name;
    private String surname;
    private String password;
    private String email;
}
