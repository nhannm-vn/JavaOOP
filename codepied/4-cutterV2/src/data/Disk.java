package data;

//cái  khuôn chuyên dùng để đúc hình tròn
public class Disk {
    //tạo cái ngăn
    private String color;
    private double radius;
    public final static double PI = 3.14;//hằng số phải viết hoa
    //nếu là k có static ==> tạo 8 hình tròn từ cái khuôn Disk thì anh đã tạo ra
    //8 số PI. 8 anh trỏ  1 nàng nếu không có final thì có thể bị chỉnh
    
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
    
    //method
    public double getPerimeter(){
        return 2 * PI * radius;
    }
    public double getArea(){
        return Math.pow(radius, 2) * PI;
    }
    
    public void paint(){
        String str = String.format("Disk:    %s|%.2f|%.2f|%.2f", color, radius
        , getPerimeter(), getArea());
        System.out.println(str);
    }
    
}
