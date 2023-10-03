package com.sumerge.stpsessionday1.controllers;

import com.sumerge.stpsessionday1.models.User;
import com.sumerge.stpsessionday1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,value = "/get-user")
    public List<User> getUsers()
    {
        return userService.getUsersData();
    }

    @PostMapping(value = "/add-user")
    public void addUser(@RequestBody User user)
    {
        userService.addUser(user);
    }

    @DeleteMapping (value = "/delete-user")
    public void deleteUser(@RequestBody User user)
    {
        userService.deleteUser(user);
    }

    @PutMapping (value = "/put-user")
    public void putUser(@RequestParam String fullName,@RequestParam double newAge)
    {
        userService.putUser(fullName,newAge);
    }
}
