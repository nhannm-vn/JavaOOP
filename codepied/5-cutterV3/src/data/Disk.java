package data;

//khuôn disk
public class Disk extends Shape {
    private double radius;
    public static final double PI = 3.14;

    //của thằng cha phải đặt lên trước
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
        return PI * Math.pow(radius, 2);
    }

    @Override
    public void paint() {
        String str = String.format("Disk: %s|%s|%.2f|%.2f|%.2f",
                owner, color, radius, getPerimeter(), getArea());
        System.out.println(str);
    }
    
    
}
