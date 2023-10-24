package org.example;

public class Vector {
    double x,y,z;



    public Vector(double x,double y,double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void printVector()
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
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
        return 0; // to be continued
    }
}
