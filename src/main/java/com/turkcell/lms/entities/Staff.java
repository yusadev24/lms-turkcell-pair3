package com.turkcell.lms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff")
public class Staff extends User{

    @Builder
    public Staff(int id, String name, String surname, String password, String email, int nationalId, String role, int staffNumber) {
        super(id, name, surname, password, email, nationalId);
        this.role = role;
        this.staffNumber = staffNumber;
    }

    @Column(name="role")
    private String role;
    @Column(name = "staff_number")
    private int staffNumber;

}