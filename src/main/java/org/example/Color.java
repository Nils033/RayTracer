package org.example;

public class Color {
protected double r = 0;
protected double g = 0;
protected double b = 0;

    public Color(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color()
    {
    }
    public Color(String name)
    {
        switch (name){
            case "black": r = 0; g = 0; b = 0; break;
            case "red": r = 1; g = 0; b = 0; break;
            case "yellow": r = 1; g = 1; b = 0;; break;
            case "white": r = 1; g = 1; b = 1;; break;
            case "green": r = 0; g = 1; b = 0;; break;
            case "magenta": r = 1; g = 0; b = 1;; break;
            case "cyan": r = 0; g = 1; b = 1;; break;
            case "blue": r = 0; g = 0; b = 1;; break;
            default: new Color();

        }
    }

    @Override
    public String toString()
    {
        return "color:" + r + "|" + g + "|" + b;
    }




public Color scalar(double s)
{
    return new Color(r*s,g*s,b*s);
}

public Color add(Color c)
{
    return new Color(r+c.r,g+c.g,b+c.b);
}

public Color multiply(Color c)
{
    return new Color(r*c.r,g*c.g,b*c.b);
}

public Color clamp()
{
    Color result = new Color();
    if(r > 1)
    {
        result.r = 1;
    }else if(r < 0)
    {
        result.r = 0;
    }
    if(g > 1)
    {
        result.g = 1;
    }else if(g < 0)
    {
        result.g = 0;
    }
    if(b > 1)
    {
        result.b = 1;
    }else if(b < 0)
    {
        result.b = 0;
    }
    return result;
}

}
