package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.GreetingData;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    GreetingRepository greetingRepository;
    public String getmessage() {
        return "Hello World";
    }
    public String sayHelloByName(String firstName, String lastName) {
        return " Hello "+firstName+" "+lastName;
    }

    public GreetingData postData(GreetingData greetingData) {
        greetingRepository.save(greetingData);
        return greetingData;
    }
}
