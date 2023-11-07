package org.example;
import java.awt.image.BufferedImage;
import java.io.File;

public class Canvas {
    protected int height;
    protected int width;
    protected String fileName;
    File outputfile = new File("image.png");


    public Canvas(int height, int width, String fileName) {
        this.height = height;
        this.width = width;
        this.fileName = fileName;

    }

    public void setPixel(int x, int y, int rgbColor)
    {

    }



}
