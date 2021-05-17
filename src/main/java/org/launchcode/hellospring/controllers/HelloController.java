package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


//    @GetMapping("") // handles a get type request
//    public String hello(){
//        return "Hello Spring!";
//    }

    // return a plain text response... until templates are learned
    @GetMapping("goodbye") // handles a get type request
    public String goodbye(){
        return "Goodbye Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='hello'>" +  //  method='post'
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
