package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.interfaces.PostRepository;
import com.codeup.springblogapp.interfaces.UserRepository;
import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.model.User;
import com.codeup.springblogapp.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }



    //    <-----VIEW ALL Posts----->
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


    //    <-----CREATE NEW Post FORM----->
    @GetMapping("/posts/create")
    public String viewCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    //    <----Create NEW POST----->
    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {

        User user = userDao.getOne(1L);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "You Created a post with SpringBlog!", post.getTitle());
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
