package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

     User user = new User(1L, "testy", "Testing", "mypassword", null);

     List<Category> categories = new ArrayList<>(){{
        add (new Category(1L, "a new Post"));
        add (new Category(2L, "a newer Post"));
        add (new Category(3L, "a newest Post"));
    }};

    List<Post> posts = new ArrayList<>(){{
        add (new Post(1L, "a new Post", "good stuff", user, categories));
        add (new Post(2L, "a newer Post", "just stuff", user, categories));
        add (new Post(3L, "a newest Post", "great stuff", user, categories));
    }};
    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<User>() {{
            add(new User(1L, "User1", "Email1", "password1", posts));
            add(new User(2L, "User2", "Email2", "password2", posts));
            add(new User(3L, "User3", "Email3", "password3", posts));
            add(new User(4L, "User4", "Email4", "password4", posts));
        }};

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