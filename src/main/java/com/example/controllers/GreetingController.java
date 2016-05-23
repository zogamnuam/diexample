package com.example.controllers;

import com.example.services.HelloWorldService;
import com.example.services.HelloWorldServiceGermanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class GreetingController {

    private HelloWorldService helloWorldService;
    private HelloWorldService helloWorldServiceGerman;
    private HelloWorldService helloWorldServiceFrench;

    //by Type
    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    //by Name
    @Autowired
    @Qualifier("helloWorldServiceGerman")
    public void setHelloWorldServiceGerman(HelloWorldService helloWorldServiceGerman){
        this.helloWorldServiceGerman = helloWorldServiceGerman;
    }

    //by Name
    @Autowired
    @Qualifier("french")
    public void  setHelloWorldServiceFranch(HelloWorldService helloWorldServiceFrench){
        this.helloWorldServiceFrench = helloWorldServiceFrench;
    }

    public String sayHello(){
        String greeting = helloWorldService.getGreeting();
        System.out.println(greeting);
        System.out.println(helloWorldServiceGerman.getGreeting());
        System.out.println(helloWorldServiceFrench.getGreeting());


        return greeting;
    }
}
