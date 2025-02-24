package com.bridgelabz.greetings.controller;

import com.bridgelabz.greetings.model.Greeting;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.bridgelabz.greetings.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingAppController {

    private final GreetingService greetingService;

    public GreetingAppController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return "GET: " + greetingService.getGreetingMessage();
    }

    @PostMapping
    public Greeting postGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        String message = "Hello, " + (firstName != null ? firstName : "Guest") +
                (lastName != null ? " " + lastName : "") + "!";
        return greetingService.saveGreeting(message);
    }

    @PutMapping
    public String putGreeting() {
        return "PUT: " + greetingService.getGreetingMessage();
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "DELETE: " + greetingService.getGreetingMessage();
    }

    @GetMapping("/params")
    public String getGreetingParams(@RequestParam(required = false) String firstName,
                                    @RequestParam(required = false) String lastName) {
        return greetingService.displayingGreeting(firstName, lastName);
    }

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        Greeting greeting = greetingService.getGreetingById(id);
        if (greeting == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting with ID " + id + " not found");
        }
        return greeting;
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
