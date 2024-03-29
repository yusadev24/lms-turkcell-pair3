package com.turkcell.lms.repositories;

import com.turkcell.lms.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
// members tablosu verisine erişmek
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
