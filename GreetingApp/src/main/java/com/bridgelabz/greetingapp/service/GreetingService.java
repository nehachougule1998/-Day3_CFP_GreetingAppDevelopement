package com.bridgelabz.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getmessage() {
        return "Hello World";
    }
    public String sayHelloByName(String firstName, String lastName) {
        return "Hello "+firstName+" "+lastName;
    }

}
