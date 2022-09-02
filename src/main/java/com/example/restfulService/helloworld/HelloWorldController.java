package com.example.restfulService.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWord helloWorldBean(){
        return new HelloWord("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWord helloWorldBean(@PathVariable String name){
        return new HelloWord(String.format("Hello World, %s", name));
    }

}
