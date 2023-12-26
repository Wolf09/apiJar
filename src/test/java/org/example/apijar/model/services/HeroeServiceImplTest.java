package org.example.apijar.model.services;


import org.example.apijar.model.dto.Heroe;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroeServiceImplTest {


    @Test
    void getHeroesTest(){
        HeroeServiceImpl hero= new HeroeServiceImpl();
        List<Heroe> heroes= hero.getHeroes();
        assertNotNull(heroes);
        assertTrue(heroes.size()>0);
        assertEquals(20, heroes.size());
    }

    @Test
    void getHeroesPorId(){
        HeroeServiceImpl hero= new HeroeServiceImpl();
        Heroe myHero=hero.getHeroe(1017100);
        assertNotNull(myHero);
        assertEquals("Integer",((Object)myHero.getId()).getClass().getSimpleName());

    }
}