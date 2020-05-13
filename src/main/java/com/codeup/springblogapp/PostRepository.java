package com.codeup.springblogapp;

import com.codeup.springblogapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long>{
    Post getPostById(long id);
    Post deleteById(long id);

}
