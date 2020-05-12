package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String viewposts(Model model) {
        List<Post> postList = new ArrayList<>();

        Post butter = new Post("Butter! The NEW Spinach !", "Recent studies show that if you eat nothing but butter, your body will be healthier than ever!");
        postList.add(butter);
        Post easyE = new Post("Easy E Alive!!?!", "The Navy SEALS claim to have footage of the apparent 'dead' Easy E crusin' down the street!");
        postList.add(easyE);
        model.addAttribute("posts", postList);
        return "/posts/index";
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
    public String SubmitCreatePost() {
        return "Viewing form for creating a new post";
    }
}
