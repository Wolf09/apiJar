package com.example.apijar;

import com.example.apijar.model.dto.Heroe;
import com.example.apijar.model.services.HeroeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiJarApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(ApiJarApplication.class, args);

    }



}
