package org.example;

public class Vector extends Tuple {


    public Vector(double x, double y, double z) {
        super(x, y, z, 0);
    }




    public Vector add(Vector v)
    {
        return new Vector(x+v.x,y+v.y,z+v.z);
    }

    public Vector subtract(Vector v)
    {
        return new Vector(x-v.x,y-v.y,z-v.z);
    }

    public Vector negation()
    {
        return new Vector(-x,-y,-z);
    }

    public Vector scalarMultiply(double scalar)
    {
        return new Vector(x*scalar,y*scalar,z*scalar);
    }

    public Vector scalarDivide(double scalar)
    {
        return new Vector(x/scalar,y/scalar,z/scalar);
    }

    public boolean equals(Vector v)
    {
        return (x == v.x) && (y == v.y) && (z == v.z);
    }
    public boolean unequals(Vector v)
    {
        return (x != v.x) || (y != v.y) || (z == v.z);
    }

    public double magnitude()
    {
        return Math.sqrt((x*x) + (y+y) +(z*z));
    }
}
