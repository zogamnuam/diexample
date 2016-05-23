package com.example.services;




//@Component
//@Profile({"default","english"})
public class HelloWorldServiceEnglishImpl implements HelloWorldService {

    @Override
    public String getGreeting() {
        return "Hello World!";
    }
}
