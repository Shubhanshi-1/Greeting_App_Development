package com.bridgelabz.greetings.controller;

import com.bridgelabz.greetings.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingAppController {

    private final GreetingService greetingService;

    public GreetingAppController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting(@RequestParam(required = false) String firstName, 
                                           @RequestParam(required = false) String lastName) {
        return Map.of("message", greetingService.getGreetingMessage(firstName, lastName));
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        String firstName = request.get("firstName");
        String lastName = request.get("lastName");
        return Map.of("message", greetingService.getGreetingMessage(firstName, lastName));
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        String firstName = request.get("firstName");
        String lastName = request.get("lastName");
        return Map.of("message", "Updated Greeting", "updated", greetingService.getGreetingMessage(firstName, lastName));
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Hello from DELETE");
    }
}
