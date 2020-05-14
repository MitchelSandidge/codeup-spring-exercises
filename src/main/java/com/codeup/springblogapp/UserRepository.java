package com.codeup.springblogapp;

import com.codeup.springblogapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
