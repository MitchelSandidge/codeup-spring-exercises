package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {

    // TODO: 1. a. Create a page at /roll-dice that asks the user to guess a number.
    //          b. There should be links on this page for 1 through 6 that should make a GET request to /roll-dice/n where n is the number guessed.
    //          c. This page should display a random number (the dice roll), the user's guess and a message based on whether or not they guessed the correct number.
    //          Bonus
    //          "Roll" a series of dice on each page load, as opposed to an individual die. Show all the rolls to the user and display how many rolls matched their guess.

    @GetMapping("/roll-dice")
    public String showRollDice(Model model){

        model.addAttribute("hasRolled", false); // The user has not rolled yet

        return "roll-dice"; // we return the string "Roll-dice" from our controller, Spring will try to find a file name roll-dice.html inside of resources/templates.

    }

    @GetMapping("/roll-dice/{n}") // n is the number guessed by user
    public String showUserSelection(@PathVariable int n, Model model){ // A Model in this context is what Spring refers to a view as

        // create instance of Random class
        Random random = new Random();
        // Generate random integers in range 0 to 6 (6 sided die)
        int randomInt = random.nextInt(6);

        // 1. Once the user has rolled
        model.addAttribute("hasRolled", true); // The user has rolled
        // 2. Show the random number
        String randomDisplay = randomInt + " was rolled.";
        model.addAttribute("randomNumber", randomDisplay);
        // 3. Display the users guess
        String guessDisplay = n + " was your guess.";
        model.addAttribute("userGuess", guessDisplay);
        // 4. Check if guess and random number match
        // 5. Tell the user if they guessed correct or incorrect
        if (randomInt == n)
            model.addAttribute("message", "NICE! Your guess was correct!");
        else
            model.addAttribute("message", "Oops :( Your guess was incorrect!");


        return "roll-dice"; // we return the string "Roll-dice" from our controller, Spring will try to find a file name roll-dice.html inside of resources/templates.
    }

}