package com.wine_api.wine_api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WineApiSpringBootTest {

    @Autowired
    private TypeController typeController;

    @Test
    void getAllTypes() throws Exception{

        assertEquals(23, typeController.getTypes().getBody().size());
    }

}
