package com.example.libraryappnew_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LibraryController {

    @Autowired
    private LibraryDao dao;

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
        map.put("status","success"); return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/entry",consumes = "application/json",produces = "application/json")
    public Map<String,String> BookEntry(@RequestBody Library l)
    {
        System.out.println(l.getTitle().toString());
        System.out.println(l.getAuthor().toString());
        System.out.println(l.getDescription().toString());
        System.out.println(l.getDistributor().toString());
        System.out.println(l.getLanguage().toString());
        System.out.println(l.getPrice());
        System.out.println(l.getPublisher().toString());
        System.out.println(l.getImage().toString());
        System.out.println(l.getReleaseyear());
        dao.save(l);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Library> BookSearch(@RequestBody Library l)
    {
        String title=l.getTitle().toString();
        System.out.println(title);
        return (List<Library>) dao.BookSearch(l.getTitle());
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Library> BookView()
    {
        return (List<Library>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public Map<String,String> BookDelete(@RequestBody Library l)
    {
        String id=String.valueOf(l.getId());
        System.out.println(id);
        dao.BookDelete(l.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
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
