package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Canvas Manfred = new Canvas(100,100,"test");
        File outputfile = new File("test.png");
        Manfred.testImage2();
        Manfred.writeImage(outputfile);
        System.out.println(Matrix.rotateY(90));
        Intersections m = new Intersections(new Intersection[]{});
        m.add(new Intersection(3, new Sphere()));
        System.out.println(m.count());


    }
}