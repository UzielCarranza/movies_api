package com.codeup.fortran_movies_api.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, ";
//    }


    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "Hello, " + name;
    }


    @GetMapping("/increment/{number}")
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is  " + (number + 1) + "!";
    }


}

