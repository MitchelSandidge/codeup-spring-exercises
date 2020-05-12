package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String add(@PathVariable long x, @PathVariable long y) {
        return "When you add " + x + " and " + y + " you get: "  + (x+y);
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String subtract(@PathVariable long x, @PathVariable long y) {
        return "When you subtract " + x + " from " + y + " you get: " + (y-x);
    }

    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiply(@PathVariable long x, @PathVariable long y) {
        return "When you multiply " + x + " and " + y + " you get: " + (y*x);
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public String divide(@PathVariable long x, @PathVariable long y) {
        return "When you divide " + x + " by " + y + " you get: " + (y/x);
    }

}
