package org.example;

public class Sphere extends Shape {
    protected Point center = new Point(0,0,0);
    protected double radius = 1;

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
                double t1 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
                double t2 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
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
