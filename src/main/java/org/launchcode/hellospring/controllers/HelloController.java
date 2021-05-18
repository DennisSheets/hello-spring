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
    public String helloWithQueryParam(@RequestParam String name, String language){
        String message;
        if(language.equals("french")){
            message = "Bonjour, " + name + "!";
        }else if(language.equals("spanish")){
            message = "Hola, " + name + "!";
        }else if(language.equals("german")) {
            message = "Hallo, " + name + "!";
        }else if(language.equals("italian")) {
            message = "Ciao, " + name + "!";
        }else if(language.equals("dutch")) {
            message = "Hallo, " + name + "!";
        } else {
            message = "Hello, " + name;
        }
        return "<b>" + message + "</b>";
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @PostMapping("form")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='/hello' method='post'>" +  //
                            "<input type='text' name='name'>" +
                            "<select name='language'>" +
                                "<option value=''>--Please choose an option--</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='english'>English</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='german'>German</option>" +
                                "<option value='italian'>Italian</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
