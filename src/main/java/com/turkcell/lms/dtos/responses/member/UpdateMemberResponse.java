package com.turkcell.lms.dtos.responses.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberResponse {
    private int id;
    private String name;
    private String surname;
    private String password;
    private String email;
}
