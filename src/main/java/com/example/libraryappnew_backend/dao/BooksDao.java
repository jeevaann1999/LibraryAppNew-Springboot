package com.example.libraryappnew_backend.dao;

import com.example.libraryappnew_backend.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksDao extends CrudRepository<Books,Integer> {
}
