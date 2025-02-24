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
    public Map<String, String> getGreeting() {
        return Map.of("message", greetingService.getGreetingMessage());
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody(required = false) Map<String, String> request) {
        String name = (request != null && request.get("name") != null) ? request.get("name") : "Guest";
        return Map.of("message", "Hello from POST", "data", name);
    }


    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        return Map.of("message", "Hello from PUT", "updated", request.get("name"));
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Hello from DELETE");
    }
}
