package org.example;

public class Resolution {
    int height;
    int width;

    public Resolution (int height, int width)
    {
        this.height = height;
        this.width = width;
    }

    public static Resolution macbook ()
    {
        return new Resolution(1800,2880);
    }
}
