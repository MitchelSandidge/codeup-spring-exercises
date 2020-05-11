package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller  // dictates tht this class is a controller in mvc
public class HelloController {

//    @GetMapping("/")
//    @ResponseBody
//    public String index() {
//        return "Index page";
//    }



    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }


//    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    @PostMapping("/upload")
    public void uploadProfile() {
        // Do something here
    }


    // ** PATH VARIAVLES ** //

//    @GetMapping("/hi/{name}")
//    @ResponseBody
//    public String sayHi(@PathVariable String name, Model model) {
//        return "Hi, " + name;
//    }

    @GetMapping("/defined-ad/{id}")
    @ResponseBody
    public String showAd(@PathVariable long id) {
        return"showing details for ad with id:" + id;
    }



    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
