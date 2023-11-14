package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void scalar() {
    }

    @Test
    void add() {
    }

    @Test
    void multiply() {
    }

    @Test
    void clamp() {
    }

    @Test
    void toDEC() {
        Color c = new Color(0.1,0,0);
        assertEquals(1671168,c.toDEC());
        Color c1 = new Color(1,0,0);
        assertEquals(16711680,c1.toDEC());
    }
}