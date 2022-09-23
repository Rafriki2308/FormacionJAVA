package com.bosonit.ej6.pathvariableheaders.Controllers;

import com.bosonit.ej6.pathvariableheaders.Model.Greeting;
import com.bosonit.ej6.pathvariableheaders.Repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        greetingRepository.addGreeting(greeting);
        return greeting;
    }

    @PostMapping(value = "/greetingJson", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Greeting addGreeting(@RequestBody Greeting greeting){
        return greeting;
    }

    @GetMapping("/user/{id}")
    public Greeting getGreetingById(@PathVariable String id) {
        return greetingRepository.getGreetingById(Integer.parseInt(id));
    }

    @PutMapping("/post")
    public Greeting modifyGreetingById(@RequestParam String val1, @RequestParam String val2){

        return greetingRepository.modifyGreetingById(Integer.parseInt(val1),val2);
    }


}