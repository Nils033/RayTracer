package org.example;

public class Point extends Tuple{


    public Point(double x, double y, double z) {
        super(x, y, z, 1);
    }

    public Vector add(Point p)
    {
        return new Vector(x+p.x,y+p.y,z+p.z);
    }

    public Point scalar(double s)
    {
        return new Point(x*s,y*s,z*s);
    }

    public Point divide(double s)
    {
        return new Point(x/s,y/s,z/s);
    }

    public Point addVector(Vector v)
    {
        return new Point(x+v.x,y+v.y,z+v.z);
    }

    public Point subVector(Vector v)
    {
        return new Point(x-v.x,y-v.y,z-v.z);
    }
}
