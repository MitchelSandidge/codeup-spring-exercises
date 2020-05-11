package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String welcome() {
        return "roll-dice";
    }


    // Different Pages for the DICE
    @GetMapping("/roll-dice/1")
    public String one() {
        return "1";
    }

    @GetMapping("/roll-dice/2")
    public String two() {
        return "2";
    }

    @GetMapping("/roll-dice/3")
    public String three() {
        return "3";
    }

    @GetMapping("/roll-dice/4")
    public String four() {
        return "4";
    }

    @GetMapping("/roll-dice/5")
    public String five() {
        return "5";
    }

    @GetMapping("/roll-dice/6")
    public String six() {
        return "6";
    }

}
