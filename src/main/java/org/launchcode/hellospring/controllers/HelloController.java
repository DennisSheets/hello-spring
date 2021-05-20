package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class HelloController {

    @GetMapping("")
    @ResponseBody
    public String lost(){
        return "You lost?";
    }

    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping ("hello-names")
    public String helloNames(Model model) {
        //ArrayList<String> names = new ArrayList<>();
        //    names.add("smoke signals");
        //    names.add("braille");
        //    names.add("Morse code");

        //List<String> names = Arrays.asList("LaunchCode","Java","JavaScript");

        ArrayList<String> names = new ArrayList<>(Arrays.asList("C#","Python","Basic"));

            model.addAttribute("names",names);
        return "hello-list";
    }

}
