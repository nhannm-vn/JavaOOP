/*
Cái phểu chuyên dùng để đúc ra những cái Disk
 */
package data;

public class Disk {
    //props
    private String color;
    private double radius;
    public static final double PI = 3.14;
    
    //constructor

    public Disk(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }
    
    //getter

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }
    
    //method tính chu vi
    public double getPerimeter(){
        return 2 * PI * radius;
    }
    
    //method tính diện tích
    public double getArea(){
        return PI * Math.pow(radius, 2);
    }
    
    //method paint
     public void paint(){
        String str = String.format("%s|%10s|%5.2f|%5.2f|%5.2f"
                                    , "Disk", color, radius, getPerimeter(), getArea());
        System.out.println(str);
    }
}
