package com.example.libraryappnew_backend.dao;

import com.example.libraryappnew_backend.model.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksDao extends CrudRepository<Books,Integer> {

    @Query(value = "SELECT `id`, `author`, `description`, `distributor`, `image`, `language`, `price`, `publisher`, `released_year`, `title` FROM `books` WHERE `title`= :title",nativeQuery = true)
    List<Books> BookSearch(@Param("title") String title);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `books` WHERE `id`= :id",nativeQuery = true)
    void BookDelete(@Param("id") Integer id);
}
