package com.codeup.blogapp.data;
import com.codeup.blogapp.security.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
Optional<User> findByEmail(String email);
}
