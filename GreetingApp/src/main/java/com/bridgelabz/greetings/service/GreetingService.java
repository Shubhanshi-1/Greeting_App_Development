package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.model.Greeting;
import com.bridgelabz.greetings.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage() {
        return "Hello, Welcome to the Greeting App!";
    }

    public String displayingGreeting(String firstName, String lastName) {
        return "Hello, " + (firstName != null ? firstName : "Guest") +
               (lastName != null ? " " + lastName : "") + "!";
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting();
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, String newMessage) {
        Optional<Greeting> greetingOptional = greetingRepository.findById(id);
        if (greetingOptional.isPresent()) {
            Greeting greeting = greetingOptional.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return null;
    }

    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
