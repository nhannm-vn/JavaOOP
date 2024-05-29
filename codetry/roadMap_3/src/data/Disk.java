package data;

public class Disk extends Shape{
     private double radius;
    public final static double PI = 3.14;
    //tạo constructor
    public Disk(String owner, String color, double radius) {//chuyển owner color
        //lên trên. Của cha đưa lên trên
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
        String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|%5.2f"
        , "DISK", owner, color, radius, getPerimeter(), getArea());
        System.out.println(str);
    }
}
