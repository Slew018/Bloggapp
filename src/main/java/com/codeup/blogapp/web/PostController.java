package com.codeup.blogapp.web;


import com.codeup.blogapp.PostsRepository;
import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    private final PostsRepository postsRepository;

    public PostController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

//    List<Category> categories = new ArrayList<>() {{
//        add(new Category(1L, "a new Post"));
//        add(new Category(2L, "a newer Post"));
//        add(new Category(3L, "a newest Post"));
//    }};

    @GetMapping
    private List<Post> getPosts() {
        return postsRepository.findAll();
    }

    @GetMapping({"id"})
    private Post getPostById(@PathVariable Long id) {
        return postsRepository.findById(id).get();
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
    }

    @PutMapping({"id"})
    private void updatePost(@RequestBody Post myPost, @PathVariable Long id) {
        System.out.println(myPost);
        postsRepository.save(myPost);
    }

    @DeleteMapping({"id"})
    private void deletePost(@PathVariable Long id) {
        postsRepository.deleteById(id);
    }
}
