package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GreetingService {

    private final List<Greeting> greetingList = new ArrayList<>(Arrays.asList(
            new Greeting("1", "Hello, World"),
            new Greeting("2", "Hallo, Welt"),
            new Greeting("3", "Ciao, Mondo"),
            new Greeting("4", "Hola, Mundo")
    ));

    public List<Greeting> getGreetingList(){
        return greetingList;
    }

    public Greeting getGreeting(String id) {
        return greetingList.stream().filter(g -> g.getId().equals(id)).findFirst().get();
    }

    public void addGreeting(Greeting greeting) {
        greetingList.add(greeting);
    }

    public void updateGreeting(Greeting greeting, String id) {
        for(int i = 0; i < greetingList.size(); i++){
            Greeting g = greetingList.get(i);
            if(g.getId().equals(id)) {
                greetingList.set(i, greeting);
            }
        }
    }

    public void deleteGreeting(String id) {
        greetingList.removeIf(g -> g.getId().equals(id));
    }
}
