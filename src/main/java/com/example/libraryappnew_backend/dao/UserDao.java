package com.example.libraryappnew_backend.dao;

import com.example.libraryappnew_backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {
}
