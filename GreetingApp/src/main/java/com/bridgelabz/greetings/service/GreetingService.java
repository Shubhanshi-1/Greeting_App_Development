package com.bridgelabz.greetings.service;


import com.bridgelabz.greetings.model.Greeting;
import java.util.List;

public interface GreetingService {
    String getGreetingMessage(String firstName, String lastName);
    Greeting saveGreeting(String message);
    List<Greeting> getAllGreetings();
}
