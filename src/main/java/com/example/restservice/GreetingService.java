package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GreetingService {

    private final List<Greeting> greetingList = new ArrayList<>(Arrays.asList(
            new Greeting(2L, "Hallo, Welt"),
            new Greeting(3L, "Ciao, Mondo"),
            new Greeting(4L, "Hola, Mundo")
    ));

    public List<Greeting> getGreetingList(){
        return greetingList;
    }


    public void addGreeting(Greeting greeting) {
        greetingList.add(greeting);
    }

    public void updateGreeting(Greeting greeting, Long id) {
        for(int i = 0; i < greetingList.size(); i++){
            Greeting g = greetingList.get(i);
            if(g.getId().equals(id)) {
                greetingList.set(i, greeting);
            }
        }
    }

    public void deleteGreeting(Long id) {
        greetingList.removeIf(g -> g.getId().equals(id));
    }
}
