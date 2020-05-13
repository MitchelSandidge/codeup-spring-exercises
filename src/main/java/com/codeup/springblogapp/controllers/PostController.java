package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.PostRepository;
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

    private final PostRepository postDao;

    public PostController(PostRepository adDao) {
        this.postDao = adDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {


        model.addAttribute("post", postDao.getPostById(id));

        return "/posts/show";
    }

    @GetMapping("/posts/delete/{id}")
    @ResponseBody
    public String deletePost(@PathVariable long id, Model model) {

        model.addAttribute("posts", postDao.deleteById(id));

        return "Post with id: " + id + " was deleted.";
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
