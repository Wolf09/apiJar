package com.example.apijar.model.services;

import com.example.apijar.model.dto.Heroe;
import com.example.apijar.model.interfaces.IHeroe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class HeroeServiceImpl implements IHeroe {
    @Autowired
    private RestTemplate restTemplate;

    public HeroeServiceImpl() {
    }



    @Override
    public List<Heroe> getHeroes() throws JsonProcessingException {

        ResponseEntity<String> responseEntity=restTemplate.getForEntity("https://gateway.marvel.com:443/v1/public/characters?apikey=f2d24302a91eb25d672fd1967f9e52d4&ts=Wed Nov 29 2023 16:09:36 GMT-0400 (hora de Bolivia)&hash=5c1d3d1e5c7bab1759046dee46cd850b",String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode properties = objectMapper.readTree(responseEntity.getBody()).get("data");
        JsonNode periods = properties.get("results");
        Heroe[] response= objectMapper.readValue(periods.toString(), Heroe[].class);
        return Arrays.asList(response);
    }

    @Override
    public Heroe getHeroe(int id) throws JsonProcessingException {
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("https://gateway.marvel.com:443/v1/public/characters/"+id+"?apikey=f2d24302a91eb25d672fd1967f9e52d4&ts=Wed Nov 29 2023 16:09:36 GMT-0400 (hora de Bolivia)&hash=5c1d3d1e5c7bab1759046dee46cd850b",String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode properties = objectMapper.readTree(responseEntity.getBody()).get("data");
        JsonNode periods = properties.get("results");
        Heroe[] response= objectMapper.readValue(periods.toString(), Heroe[].class);
        return response[0];
    }
}
