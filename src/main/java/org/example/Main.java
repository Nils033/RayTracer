package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Canvas Manfred = new Canvas(Resolution.macbook(),"test");
        File outputfile = new File("test.png");
        Manfred.writeImage(outputfile);


    }
}