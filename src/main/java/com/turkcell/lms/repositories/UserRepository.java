package com.turkcell.lms.repositories;

import com.turkcell.lms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
//User tablosuna erişim
public interface UserRepository extends JpaRepository<User, Integer> {
}
