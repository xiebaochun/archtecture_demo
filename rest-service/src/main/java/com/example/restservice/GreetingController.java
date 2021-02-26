package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

<<<<<<< HEAD
//import com.ecrisson.org.User;
=======

>>>>>>> cd372fe204b4623b619647023ddafbab46c5af77
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

<<<<<<< HEAD
//    @Autowired
//    private User user;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {


        return new Greeting(counter.incrementAndGet(), String.format(template, "hello"));
=======

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, "name"));
>>>>>>> cd372fe204b4623b619647023ddafbab46c5af77
    }
}