package com.turkcell.lms.repositories;

import com.turkcell.lms.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// members tablosu verisine erişmek
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByEmail(String email);

    Optional<Member> findByMemberNumber(int memberNumber);
}
