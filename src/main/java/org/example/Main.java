package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Canvas Manfred = new Canvas(1000,1000,"test");
        File outputfile = new File("test.png");
        Manfred.sphereImage3();
        Manfred.writeImage(outputfile);
        System.out.println(Matrix.rotateY(90));//pi halbe und so weiter
        Intersections m = new Intersections(new Intersection[]{});
        m.add(new Intersection(3, new Sphere()));
        System.out.println(m.count());


    }
}