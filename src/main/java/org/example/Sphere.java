package org.example;

public class Sphere extends Shape {
    protected Point center = new Point(0,0,0);
    protected double radius = 1;

    protected double t1;
    protected double t2;

    public Sphere(double radius)
    {
        this.radius = radius;
    }
    public Sphere(double radius, Matrix matrix)
    {
        this.radius = radius;
        this.transform = matrix;
    }

    public double getT1() {
        return t1;
    }

    public double getT2()
    {
        return t2;
    }

    public double getTMinimum()
    {
        return Math.min(t1,t2);
    }

    public Sphere() {}

    @Override
    public Intersections intersect(Ray ray)
{
    Intersections result = new Intersections(new Intersection[]{});
            // Vektor vom Ursprung des Strahls zum Mittelpunkt der Kugel
            Vector oc = ray.getOrigin().subtract(center);

            // Koeffizienten für die quadratische Gleichung
            double a = ray.getDirection().dot(ray.getDirection());
            double b = 2.0 * ray.getDirection().dot(oc);
            double c = oc.dot(oc) - (radius * radius);

            // Diskriminante
            double discriminant = (b * b) - (4 * a * c);

            // Wenn die Diskriminante negativ ist, gibt es keine Schnittstellen
            if (discriminant < 0) {
                return result;
            } else {
                // Berechne den Parameter t für den Schnittpunkt
                t1 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
                t2 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
                result.add(new Intersection(t1, this));
                result.add(new Intersection(t2, this));

            }
        return result;
        }

    @Override
    public Vector normalAt(Point point) {
        return point.subtract(center).normalized();
    }
}
