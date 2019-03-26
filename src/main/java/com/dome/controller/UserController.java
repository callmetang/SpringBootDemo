package com.dome.controller;

import com.dome.beans.User;
import com.dome.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/getAll")
    public List<User> hello() {
        return userService.getAllUsers();
    }
}
