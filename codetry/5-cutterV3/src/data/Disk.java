package data;

//class disk
public class Disk extends Shape{
    private double radius;
    public static final double PI = 3.14;

    public Disk(String owner, String color, double radius) {
        super(owner, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    
    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * PI;
    }

    @Override
    public void paint() {
        String str = String.format("Disk: %s|%s|%.2f|%.2f|%.2f|", owner, color, 
                radius, getPerimeter(), getArea());
        System.out.println(str);
    }
    
    
}
