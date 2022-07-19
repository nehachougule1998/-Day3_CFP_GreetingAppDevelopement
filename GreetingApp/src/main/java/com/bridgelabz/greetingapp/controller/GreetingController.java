package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.GreetingData;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    GreetingService greetingService;
    //UC1
    @GetMapping("/getmessage")
    public String getmessage(){
        return "Hello World";
    }
    @GetMapping("/getbyparam")
    public String getByParam(@RequestParam String name){
        return " Hello " +name;
    }
    @GetMapping("/getpath/{name}")
    public String getpath(@PathVariable String name){
        return " Hello " +name;
    }

    //UC2
    @GetMapping("/getbyservice")
    public String getbyservice(){
        String message=greetingService.getmessage();
        return message;
    }

    //UC3
    @GetMapping("/hello")
    public String sayPosting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        if (lastName == null) lastName = "";
        else if (firstName == null) firstName = "";
        else if (firstName == null && lastName == null) {
            firstName = "";
            lastName = "";
        }
        return greetingService.sayHelloByName(firstName, lastName);
    }

    //UC4
    @PostMapping("/getdata")
    public GreetingData getdata(@RequestBody GreetingData greetingData){
        GreetingData greetingData1 = greetingService.postData(greetingData);
        return greetingData1;
    }

}
