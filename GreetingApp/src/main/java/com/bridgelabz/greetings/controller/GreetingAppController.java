package com.bridgelabz.greetings.controller;

import com.bridgelabz.greetings.model.Greeting;
import com.bridgelabz.greetings.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingAppController {

    private final GreetingService greetingService;

    public GreetingAppController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/{id}")
    public Map<String, String> getGreetingById(@PathVariable String id) {
        return Map.of("message", "Greeting with ID: " + id);
    }

    @PostMapping
    public Greeting postGreeting(@RequestBody Map<String, String> request) {
        String firstName = request.get("firstName");
        String lastName = request.get("lastName");
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Hello from DELETE");
    }
}
