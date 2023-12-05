package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionsTest {

    @Test
    void add() {
        Ray ray = new Ray(new Point(0,0,-5),new Vector(0,0,1));
        Sphere sphere = new Sphere();
        Intersections xs = sphere.intersect(ray);
        assertEquals(2,xs.count());
    }

    @Test
    void count() {
    }
}