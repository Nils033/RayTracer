package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    Vector vector = new Vector(5,3,8);
    Vector change = new Vector(4,-3,2);

    @Test
    void add() {
        Vector vector = new Vector(5,3,8);
        Vector change = new Vector(4,-3,2);
        assertEquals(new Vector(9,0,10),vector.add(change));
    }

    @Test
    void subtract() {

        Vector result = vector.subtract(change);
        assertEquals(4, change.x);
    }

    @Test
    void negation() {
        Vector vector = new Vector(5,3,8);
        Vector change = new Vector(4,-3,2);
        assertEquals(new Vector(-5,-3,-8),vector.negation());
    }

    @Test
    void scalarMultiply() {
    }

    @Test
    void scalarDivide() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void unequals() {
    }

    @Test
    void magnitude() {
    }
}