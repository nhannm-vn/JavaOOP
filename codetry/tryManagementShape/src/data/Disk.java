package data;
//quản lí hình tròn



public class Disk extends Shape {
    //ghi ra các props riêng
    private double radius;
    public static final double PI = 3.14;
    
    //cái phểu
    //đưa thuộc tính chung lên trước
    public Disk(String owner, String color, double radius) {
        super(owner, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    
    //đời con vá các lỗ, tự định nghĩa cho riêng mình
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
        String str = String.format("%s|%s|%s|%.2f|%.2f|%.2f|", "Disk"
        , owner, color, radius, getPerimeter(), getArea());
        System.out.println(str);
    }
    
    
    
}
