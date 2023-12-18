package org.example;

public abstract class Shape {
    protected Matrix transform = Matrix.unit();
    public abstract Intersections intersect(Ray ray);
    public abstract Vector normalAt(Point point);
}
