package org.example;

public class Tuple {

    double x,y,z;


    public Tuple(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void printTuple()
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

}
