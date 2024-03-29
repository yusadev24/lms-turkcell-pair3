package com.turkcell.lms.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "staff")
public class Staff extends User{

    @Column(name="role")
    private String role;
    @Column(name = "staff_number")
    private int staffNumber;

}