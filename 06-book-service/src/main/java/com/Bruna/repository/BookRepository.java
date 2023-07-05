package com.Bruna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bruna.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
