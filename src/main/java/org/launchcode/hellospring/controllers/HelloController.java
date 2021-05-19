package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller


public class HelloController {




    // return a plain text response... until templates are learned
    @GetMapping("goodbye") // handles a get type request
    @ResponseBody
    public String goodbye(){
        return "Goodbye Spring!";
    }

    @RequestMapping(value="hello",method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='/hello' method='post>" +
                            "<input type='text' name='gtname'>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
