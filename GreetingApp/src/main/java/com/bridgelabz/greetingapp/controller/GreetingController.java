package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.GreetingData;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
public class GreetingController {
    @Autowired
    GreetingService greetingService;
    @Autowired
    GreetingRepository greetingRepository;
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

    //UC5
    @GetMapping("/getbyid/{id}")
    public Optional<GreetingData> getmsgbyid (@PathVariable int id){
        Optional<GreetingData> response = greetingService.getmsgbyid(id);
        return response;
    }
    //UC6
    @GetMapping("/getallData")
    public List<GreetingData> getallData(){
        List<GreetingData> data=greetingService.getallData();
        return data;
    }
    //UC7
    @PutMapping("/edit/{id}")
    public GreetingData edit(@RequestBody GreetingData user,@PathVariable Integer id) {
        return greetingService.editData(user,id);
    }


}
