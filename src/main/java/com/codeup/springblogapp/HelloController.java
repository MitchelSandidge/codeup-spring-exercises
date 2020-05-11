package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller  // dictates tht this class is a controller in mvc
public class HelloController {

//    @GetMapping("/")
//    @ResponseBody
//    public String index() {
//        return "Index page";
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h2><em>Hello From SPRIng<em><h2>";
    }


//    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    @PostMapping("/upload")
    public void uploadProfile() {
        // Do something here
    }


    // ** PATH VARIAVLES ** //

    @GetMapping("/hi/{name}")
    @ResponseBody
    public String sayHi(@PathVariable String name) {
        return "Hi, " + name;
    }

    @GetMapping("/defined-ad/{id}")
    @ResponseBody
    public String showAd(@PathVariable long id) {
        return"showing details for ad with id:" + id;
    }


}
