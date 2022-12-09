package com.example.libraryappnew_backend.controller;


import com.example.libraryappnew_backend.dao.BooksDao;
import com.example.libraryappnew_backend.dao.UserDao;
import com.example.libraryappnew_backend.model.Books;
import com.example.libraryappnew_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {

    @Autowired
    private BooksDao dao;

    @Autowired
    private UserDao d;
    @PostMapping("/")
    public String AdminLogin()
    {
        return "Welcome to admin login page";
    }
    @PostMapping("/login")
    public String UserLogin()
    {
        return "Welcome to user login page";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/register",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserRegister(@RequestBody User u)
    {
        System.out.println(u.getAadhar().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getConfirm().toString());
        System.out.println(u.getDob().toString());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getName().toString());
        System.out.println(u.getPincode());
        System.out.println(u.getPassword().toString());
        System.out.println(u.getPhone());
        System.out.println(u.getUsername().toString());
        d.save(u);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/entry",consumes = "application/json",produces = "application/json")
    public Map<String,String> BookEntry(@RequestBody Books b)
    {
        System.out.println(b.getTitle().toString());
        System.out.println(b.getAuthor().toString());
        System.out.println(b.getDescription().toString());
        System.out.println(b.getDistributor().toString());
        System.out.println(b.getLanguage().toString());
        System.out.println(b.getPrice());
        System.out.println(b.getPublisher().toString());
        System.out.println(b.getImage().toString());
        System.out.println(b.getReleasedYear());
        dao.save(b);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Books> BookView()
    {
        return (List<Books>)  dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Books> BookSearch(@RequestBody Books b) {
        String title = b.getTitle().toString();
        System.out.println(title);
        return (List<Books>) dao.BookSearch(b.getTitle());
    }

    @PostMapping("/issue")
    public String BookIssue()
    {
        return "Welcome to book issue page";
    }
    @PostMapping("/edit")
    public String BookEdit()
    {
        return "Welcome to book edit page";
    }
}
