package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "api/categories", headers = "Accept=application/json")
public class CategoriesController {

    List<Category> categories = new ArrayList<>(){
        {
            add(new Category(1L, "a new Post"));
            add(new Category(2L, "a newer Post"));
            add(new Category(3L, "a newest Post"));
        }};

    Collection<Post> userPosts = new ArrayList<>(){{
        add(new Post(1L, "Post1", "a post", null, categories));
        add(new Post(2L, "Post2", "a post", null, categories));
        add(new Post(3L, "Post3", "a post", null, categories));
    }};

        @GetMapping
    private Category getPostsByCategory(@RequestParam String categoryName){

            Category Categories = new Category(1L, "Tech");

            Categories.setPosts(userPosts);

            System.out.println(categoryName);
            return Categories;
        }
    }

