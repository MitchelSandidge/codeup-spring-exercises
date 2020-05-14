package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.PostRepository;
import com.codeup.springblogapp.UserRepository;
import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }



    //    <-----VIEW ALL Posts----->
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


    //    <-----CREATE NEW Post FORM----->
    @GetMapping("/posts/create")
    public String viewCreateForm() {


        return "posts/create";
    }


    //    <----Create NEW POST----->
    @GetMapping("/posts/new")
    public String create(String title, String body) {

        User user = userDao.getOne(1L);
        Post newPost = new Post(title, body, user);
        postDao.save(newPost);
        return "redirect:/posts";
    }


    //    <-----VIEW INDIVIDUAL Post----->
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {

        model.addAttribute("post", postDao.getPostById(id));
        return "/posts/show";
    }







    //    Edit a post
    @GetMapping("/posts/edit/{id}")
    public String postEditForm(@PathVariable long id, Model model) {
        Post post = postDao.getPostById(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }
    @PostMapping("/posts/edit/{id}")
    public String postEdit(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = postDao.getPostById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }



    //    <-----DELETE Post----->
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {

        postDao.deleteById(id);
        return "redirect:/posts";
    }


}
