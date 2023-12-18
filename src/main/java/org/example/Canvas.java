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
    public Canvas(Resolution r, String fileName)
    {
        this.width = r.width;
        this.height = r.height;
        this.fileName=fileName;
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

    public void exampleImage1()
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                Color c = new Color((double) i /height, (double) j/width, (double) j /width);
                setPixel(j,i,c.toDEC());
            }
        }
    }

    public void exampleImage2()
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j< width; j++)
            {
                Color c = new Color((double) i, (double) j, (double) i-j);
                setPixel(j,i,c.toDEC());
            }
        }
    }
    public void simpleColor(Color c)
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x< width; x++)
            {
                setPixel(x,y, c.toDEC());
            }
        }
    }
    public void testImage1()
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x< width; x++)
            {
                Color c = new Color((double) x/height, (double) y/width, 0.0);
                setPixel(x,y,c.toDEC());
            }
        }
    }
    public void testImage2()
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x< width; x++)
            {
                Point p = new Point(x,y,-100);
                Vector v = p.subtract(new Point((double) width /2, (double) height /2,0));
                double distance = (v.magnitude()-100)/100;
                Color c = new Color(distance, distance, distance);
                setPixel(x,y,c.toDEC());
            }
        }
    }

    /*public void sphereImage1()
    {
        Point camera = new Point(0, 0,-5);
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x< width; x++)
            {
                Point p = new Point((double) x-((double) width /2), (double) y-((double) height /2),0);
                Ray ray = new Ray(camera,camera.subtract(p));
                Sphere sphere = new Sphere(10);

                if(sphere.intersect(ray).count() > 0)
                {
                    /*System.out.println("Schnitt!");


                    setPixel(x,y,new Color(1,0,0).toDEC());
                }

            }
        }


    }

     */


    public void sphereImage1Zoom()
    {
        Point camera = new Point(0, 0,-5);
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x< width; x++)
            {
                Point p = new Point(((double) x-((double) width /2))/((double)width/3), ((double) y-((double) height /2))/((double)height/3),0);
                Ray ray = new Ray(camera,camera.subtract(p));
                Sphere sphere = new Sphere(1);//geht nur bis 4 ab 5 ganzes Bild ausgefüllt

                if(sphere.intersect(ray).count() > 0)
                {
                    /*System.out.println("Schnitt!");

                     */
                    setPixel(x,y,new Color((double)x/width,(double)y/height,0).toDEC());
                }
                else
                {
                    setPixel(x,y,new Color(0,0,1).toDEC());
                }

            }
        }


    }
    public void sphereImage2() {
        Point camera = new Point(0, 0, -5);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Point p = new Point(((double) x-((double) width /2))/((double)width/3), ((double) y-((double) height /2))/((double)height/3),0);
                Ray ray = new Ray(camera, camera.subtract(p));
                Sphere sphere = new Sphere(1);//geht nur bis 4 ab 5 ganzes Bild ausgefüllt

                if (sphere.intersect(ray).count() > 0) {
                    /*System.out.println("Schnitt!");

                     */
                    setPixel(x, y, new Color((double) x / width, (double) y / height, 0).toDEC());
                }

            }
        }


    }
    public void sphereImage3() {
        Point camera = new Point(0, 0, -5);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Point p = new Point(((double) x-((double) width /2))/((double)width/3), ((double) y-((double) height /2))/((double)height/3),0);
                Ray ray = new Ray(camera, camera.subtract(p));
                Sphere sphere = new Sphere(1);//geht nur bis 4 ab 5 ganzes Bild ausgefüllt

                if (sphere.intersect(ray).count() > 0) {
                    double color = Math.abs(sphere.getTMinimum());
                    setPixel(x, y, new Color(color,color,color).toDEC());
                }

            }
        }


    }

}
