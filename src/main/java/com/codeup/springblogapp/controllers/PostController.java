package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.PostRepository;
import com.codeup.springblogapp.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository adDao) {
        this.postDao = adDao;
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

        Post newPost = new Post(title, body);
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



//    //    <-----EDIT Post FORM----->
//    @GetMapping("/posts/edit/{id}")
//    public String viewEditForm(@PathVariable long id, Model model) {
//
//        model.addAttribute("post", postDao.getPostById(id));
//
//
//        return "/posts/edit";
//    }





    //    <-----DELETE Post----->
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {

        postDao.deleteById(id);
        return "redirect:/posts";
    }



//    @GetMapping("/posts")
//    public String viewPosts(Model model) {
//        List<Post> postList = new ArrayList<>();
//
//        Post butter = new Post("Butter! The NEW Spinach !", "Recent studies show that if you eat nothing but butter, your body will be healthier than ever!", 1);
//        postList.add(butter);
//        Post easyE = new Post("Easy E Alive!!?!", "The Navy SEALS claim to have footage of the apparent 'dead' Easy E crusin' down the street!", 2);
//        postList.add(easyE);
//        model.addAttribute("posts", postList);
//        return "/posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String viewPost(@PathVariable long id, Model model) {
//
//        Post butter = new Post("Butter! The NEW Spinach !", "Recent studies show that if you eat nothing but butter, your body will be healthier than ever!", id);
//        model.addAttribute("post", butter);
//
//        return "/posts/show";
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String createPost() {
//        return "Viewing form for creating a new post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String SubmitCreatePost() {
//        return "Viewing form for creating a new post";
//    }
}
