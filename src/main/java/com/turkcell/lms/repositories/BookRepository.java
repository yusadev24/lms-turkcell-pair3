package com.turkcell.lms.repositories;

import com.turkcell.lms.entities.Book;
import com.turkcell.lms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
