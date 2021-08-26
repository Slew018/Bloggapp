package com.codeup.blogapp.data;

import com.codeup.blogapp.security.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
