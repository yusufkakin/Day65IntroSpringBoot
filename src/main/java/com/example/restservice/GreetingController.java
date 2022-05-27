package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    //GET ALL THE LIST
    @GetMapping("/greeting")
    public List<Greeting> getGreetingList(){
        return greetingService.getGreetingList();
    }

    //GET SPECIFIC GREETING WITH AN ID
    @GetMapping("/greeting/{id}")
    public Greeting getList(@PathVariable String id) {
        return greetingService.getGreeting(id);
    }

    //POST A GREETING
    @PostMapping("/greeting")
    public void addGreeting(@RequestBody Greeting greeting) {
        greetingService.addGreeting(greeting);
    }

    //UPDATE A GREETING USING AN ID
    @PutMapping("/greeting/{id}")
    public void updateGreeting(@RequestBody Greeting greeting, @PathVariable String id) {
        greetingService.updateGreeting(greeting, id);
    }

    //DELETE A GREETING USING AN ID

    @DeleteMapping("/greeting/{id}")
    public void deleteGreeting(@PathVariable String id) {
        greetingService.deleteGreeting(id);
    }
}