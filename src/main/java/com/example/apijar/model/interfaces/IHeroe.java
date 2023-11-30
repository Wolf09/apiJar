package com.example.apijar.model.interfaces;

import com.example.apijar.model.dto.Heroe;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IHeroe {
    List<Heroe> getHeroes() throws JsonProcessingException;
    Heroe getHeroe(int id) throws JsonProcessingException;
}
