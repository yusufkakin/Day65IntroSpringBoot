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
    public Greeting2 greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting2(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private GreetingService greetingService;

    //GET ALL THE LIST
    @GetMapping("/greeting1")
    public List<Greeting> getGreetingList(){
        return greetingService.getGreetingList();
    }

    //GET SPECIFIC GREETING WITH AN ID
    @GetMapping("/greeting1/{id}")
    public Greeting getList(@PathVariable String id) {
        return greetingService.getGreeting(id);
    }

    //POST A GREETING
    @PostMapping("/greeting1")
    public void addGreeting(@RequestBody Greeting greeting) {
        greetingService.addGreeting(greeting);
    }

    //UPDATE A GREETING USING AN ID
    @PutMapping("/greeting1/{id}")
    public void updateGreeting(@RequestBody Greeting greeting, @PathVariable String id) {
        greetingService.updateGreeting(greeting, id);
    }

    //DELETE A GREETING USING AN ID

    @DeleteMapping("/greeting1/{id}")
    public void deleteGreeting(@PathVariable String id) {
        greetingService.deleteGreeting(id);
    }
}