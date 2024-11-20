package com.spang.prod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spang.prod.model.Word;
import com.spang.prod.service.WordService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WordService service;

    @GetMapping("/login")
    public Word userLogin(@RequestParam String user, @RequestParam String pass) {
        // todo: create user login service function
        // return service.userLogin(user, pass);
        return null;
    }

    // todo: create rest of user handling endpoints
}