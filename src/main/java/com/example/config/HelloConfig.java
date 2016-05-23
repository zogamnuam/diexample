package com.example.config;

import com.example.services.HelloWorldFactory;
import com.example.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class HelloConfig {

    @Bean
    public HelloWorldFactory helloWorldFactory(){
        return new HelloWorldFactory();
    }

    @Bean
    @Profile("english")
    @Primary
    public HelloWorldService helloWorldServiceEnglish(HelloWorldFactory factory){
        return factory.createHelloWorldService("en");
    }

    @Bean
    @Profile("spanish")
    public HelloWorldService helloWorldServiceSpanish(HelloWorldFactory factory){
        return factory.createHelloWorldService("es");
    }

    @Bean
    public HelloWorldService helloWorldServiceGerman(HelloWorldFactory factory){
        return factory.createHelloWorldService("de");
    }

    @Bean(name="french")
    public HelloWorldService helloWorldServiceFrance(HelloWorldFactory factory){
        return factory.createHelloWorldService("fr");
    }


    /*@Value("${spring.profiles.active}")
    private String language;


    @Bean
    public HelloWorldService helloWorlFactory(){
        return new HelloWorldFactory().createHelloWorldService(language);
    }*/
}
