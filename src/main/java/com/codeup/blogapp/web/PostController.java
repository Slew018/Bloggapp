package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    List<Category> categories = new ArrayList<>(){{
        add (new Category(1L, "a new Post"));
        add (new Category(2L, "a newer Post"));
        add (new Category(3L, "a newest Post"));
    }};

    @GetMapping
    private List<Post> getPosts(){

        User user = new User(1L, "testy", "Testing", "mypassword", null);

        return new ArrayList<Post>(){{
        add (new Post(1L, "a new Post", "good stuff", user, categories));
        add (new Post(2L, "a newer Post", "just stuff", user, categories));
        add (new Post(3L, "a newest Post", "great stuff", user, categories));
    }};
    }

    @GetMapping({"id"})
    private Post getPostById(@PathVariable Long id){
        // /api/posts/1
        User user = new User(1L, "testy", "Testing", "mypassword", null);
        if(id == 1){
            return new Post(1L, "A new Post", "good stuff", user, categories);
        }else{
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping({"id"})
    private void updatePost(@RequestBody Post myPost, @PathVariable Long id){
        System.out.println(myPost);
    }

    @DeleteMapping({"id"})
    private void deletePost(@PathVariable Long id){

    }
}
