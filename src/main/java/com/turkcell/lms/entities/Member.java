package com.turkcell.lms.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member extends User{

    @Column(name="member_number")
    private int memberNumber;
    @Column(name="start_date")
    private LocalDate startDate;

    @OneToMany(mappedBy = "member")
    @JsonBackReference
    private List<Loan> loans;
}
