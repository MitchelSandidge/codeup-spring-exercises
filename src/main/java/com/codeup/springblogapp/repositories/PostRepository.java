package com.codeup.springblogapp.repositories;

import com.codeup.springblogapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long>{
    Post getPostById(long id);
    Post deleteById(long id);
    Post getPostByTitle(String title);

    Post findPostByTitle(String post_to_be_deleted);
}
