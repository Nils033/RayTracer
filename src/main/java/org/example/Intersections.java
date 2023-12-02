package org.example;

import java.util.Arrays;

public class Intersections {
    protected Intersection[] intersections;
    public Intersections(Intersection[] i)
    {
        this.intersections = i;
    }

    public void add(Intersection i)
    {
        intersections = Arrays.copyOf(intersections,intersections.length+1);
        intersections[intersections.length-1] = i;
    }

}
