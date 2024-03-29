package com.turkcell.lms.services.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMembersResponse {
    private int id;
    private String name;
    private String surname;
}
