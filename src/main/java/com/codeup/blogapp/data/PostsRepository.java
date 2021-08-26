package com.codeup.blogapp.data;

import com.codeup.blogapp.security.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long>{

}
