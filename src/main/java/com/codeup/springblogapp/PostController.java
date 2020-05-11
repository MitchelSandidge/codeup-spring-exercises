package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts() {
        return "This is a list of all the posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable long id) {
        return "Viewing post with id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Viewing form for creating a new post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost() {
        return "Viewing form for creating a new post";
    }
}
