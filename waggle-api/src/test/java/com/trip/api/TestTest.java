package com.trip.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {

    private JacocoTest test = new JacocoTest();

    @Test
    void hello() {
        String result = test.hello("바");
        assertEquals(result, "보");
    }
}