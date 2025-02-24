package com.bridgelabz.greetings.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String getGreetingMessage() {
        return "Hello World";
    }
}
