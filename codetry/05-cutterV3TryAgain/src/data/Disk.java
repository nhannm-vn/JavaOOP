package data;

//quản lí hình tròn
public class Disk extends Shape {
    //đặc điểm riêng
    private double radius;
    public final static double PI  = 3.14;
    //số PI cuối cùng không thể thay đổi đc và toàn bộ đều xài chung 3.14 k phân mảnh
    
    //tạo cái phễu
    //đặc tính chung thì đưa lên đầu
    public Disk(String owner, String color, double radius) {
        super(owner, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    //độ lại hàm riêng

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
        //phương áp giúp in ra trong 1 lần
        String str = String.format("Disk:   %s|%s|%.2f|%.2f|%.2f|", owner, 
                color, radius, getPerimeter(), getArea());
        System.out.println(str);
    }
    
}
