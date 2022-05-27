package com.example.restservice;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    //MAIN ASSIGNMENT FOR SPRING.IO APP
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private GreetingService greetingService;

    //GET ALL THE LIST
    @GetMapping("/greetinglist")
    public List<Greeting> getGreetingList(){
        return greetingService.getGreetingList();
    }

    //POST A GREETING
    @PostMapping("/greeting")
    public void addGreeting(@RequestBody Greeting greeting) {
        greetingService.addGreeting(greeting);
    }

    //UPDATE A GREETING USING AN ID
    @PutMapping("/greeting/{id}")
    public void updateGreeting(@RequestBody Greeting greeting, @PathVariable Long id) {
        greetingService.updateGreeting(greeting, id);
    }

    //DELETE A GREETING USING AN ID
    @DeleteMapping("/greeting/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }
}