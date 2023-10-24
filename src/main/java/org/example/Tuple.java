package org.example;

public class Tuple {

    protected double x,y,z,w;
    double e = 0.00001;
    @Override
    public boolean equals(Object obj)
    {

        if(obj instanceof Tuple other)
        {
            return ((Math.abs(this.x - other.x) < e) &&
                    (Math.abs(this.y - other.y) < e) &&
                    (Math.abs(this.z - other.z) < e) &&
                    (Math.abs(this.w - other.w) < e));
        }
        return false;

    }


    public Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

}
