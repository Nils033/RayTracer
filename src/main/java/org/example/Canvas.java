package org.example;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Canvas {
    protected int height;
    protected int width;
    protected String fileName;
    protected BufferedImage image;
    File outputfile;
    public Canvas(int height, int width, String fileName) {
        this.height = height;
        this.width = width;
        this.fileName = fileName;
        File outputfile = new File(fileName +".png");
        image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    }

    public void writeImage(File outputfile) throws IOException {
        ImageIO.write((RenderedImage) image,"png",outputfile);
    }

    public void setPixel(int x, int y, int rgbColor)
    {
        image.setRGB(x,y,rgbColor);
    }

    public void ExampleImage1()
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j< width; j++)
            {
                Color c = new Color((double) i /height, (double) j /width, (double) i /j);
                setPixel(i,j,c.toDEC());
            }
        }
    }

    public void ExampleImage2()
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j< width; j++)
            {
                Color c = new Color((double) i, (double) j, (double) 0);
                setPixel(i,j,c.toDEC());
            }
        }
    }



}
