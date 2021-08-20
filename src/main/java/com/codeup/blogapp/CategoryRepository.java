package com.codeup.blogapp;

import com.codeup.blogapp.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Post, Long> {
}
