package org.example;

public class Ray
{
    private final Point origin;
    private final Vector direction;
    public Ray( Point origin, Vector direction)
    {
        this.origin = origin;
        this.direction = direction;
    }
    public Ray( Point from, Point to)
    {
        this.origin = from;
        this.direction = to.subtract(from).normalized();
    }
    public Point pointAt(double t)
    {
        return origin.add(direction.scalarMultiply(t));
    }
    public Point getOrigin()
    {
        return origin;
    }

    public Vector getDirection()

    {
        return direction;
    }
}

/*package org.example;

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

 */
