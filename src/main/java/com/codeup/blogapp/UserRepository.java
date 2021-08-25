package com.codeup.blogapp;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
User findByEmail(String email);
}
