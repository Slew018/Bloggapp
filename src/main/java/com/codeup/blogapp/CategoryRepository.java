package com.codeup.blogapp;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
