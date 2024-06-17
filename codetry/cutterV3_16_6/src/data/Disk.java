/*
chuyên đúc ra những hình tròn
 */
package data;
public class Disk extends Shape{
    //prop
    private double radius;
    public final static double PI  = 3.14;
    
    //constructor

    public Disk(String owner, String color, double radius) {
        super(owner, color);
        this.radius = radius;
    }
    
    //getter

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
    public void showInfor() {
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|6.2f|6.2f"
              , "Disk", owner, color, radius, getPerimeter(), getArea());
    }
    
    
}
