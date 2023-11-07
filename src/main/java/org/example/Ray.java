package org.example;

public class Ray {
    Point origin;
    Vector direction;

    public Ray(Point p, Vector v)
    {
        origin = p;
        direction = v;
    }

    public Ray(Point origin, Point direction)
    {
        this.origin = origin;
        this.direction = direction.subtract(origin);
        this.direction = this.direction.normalized();
    }
}
