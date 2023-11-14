package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void subtract() {
        Point p = new Point(1,1,1);
        Point p2 = new Point(0,0,0);
        assertEquals(p2.subtract(p),new Vector(-1,-1,-1));
    }

    @Test
    void add() {
    }

    @Test
    void scalar() {
    }

    @Test
    void divide() {
    }

    @Test
    void addVector() {
    }

    @Test
    void subVector() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void unequals() {
    }

    @Test
    void min() {
    }

    @Test
    void max() {
    }
}