package com.bridgelabz.greetings.service;

import org.springframework.stereotype.Service;
import com.bridgelabz.greetings.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.bridgelabz.greetings.repository.*;
import org.springframework.context.annotation.ComponentScan;



@Service
@ComponentScan(basePackages = "com.bridgelabz.demo.repository")
public class GreetingService {
	
	@Autowired
    private GreetingRepository greetingRepository;

    public String getGreetingMessage() {
        return "Hello from BridgeLabz";
    }
    
    public String displayingGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + " from BridgeLabz";
        } else if (firstName != null) {
            return "Hello " + firstName + " from BridgeLabz";
        } else if (lastName != null) {
            return "Hello " + lastName + " from BridgeLabz";
        } else {
            return "Hello World";
        }
    }
    
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }
    
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }
}