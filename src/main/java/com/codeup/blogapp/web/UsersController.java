package com.codeup.blogapp.web;


import com.codeup.blogapp.UserRepository;
import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    private void createUser(@RequestBody User myUser) {

        System.out.println(myUser.getId());
        System.out.println(myUser.getUsername());
        System.out.println(myUser.getEmail());
        System.out.println(myUser.getPassword());
        System.out.println(myUser.getRole());
    }

    @PutMapping("{id}")
    private void updateUser(@RequestBody User myUser, @PathVariable Long id) {

        System.out.println(myUser.getId());
        System.out.println(myUser.getUsername());
        System.out.println(myUser.getEmail());
        System.out.println(myUser.getPassword());
        System.out.println(myUser.getRole());
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
    }


}