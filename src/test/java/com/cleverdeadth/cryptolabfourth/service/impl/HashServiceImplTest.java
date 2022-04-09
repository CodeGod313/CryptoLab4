package com.cleverdeadth.cryptolabfourth.service.impl;

import com.cleverdeadth.cryptolabfourth.service.HashService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HashServiceImplTest {

    HashService hashService;
    String message;

    @BeforeAll
    void setUp() {
        hashService = new HashServiceImpl();
        message = "BSUIR";
    }

    @Test
    void generateHash() {
        String expected = "ff7cbdf2";
        String actual = hashService.generateHash(message);
        Assertions.assertEquals(expected, actual);
    }
}