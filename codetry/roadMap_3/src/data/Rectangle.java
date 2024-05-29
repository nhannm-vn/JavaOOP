/*
Rectangle kế thừa cha để lấy lại những gì nó đã đưa gửi lên cho ổng giúp nó khôi
phục trạng thái ban đầu như chưa có kế thừa
**Các bước để tiếp nhận kế thừa
0.Tạo class con
1.Khai báo đặc tính của riêng con
2.Cho con nhận cha thông qua extends Shape
3.Tạo constructor
4.Làm phần việc bổ sung mà cha giao cho(nếu có), bổ sung code độ lại cho phù hợp

 */
package data;

public class Rectangle extends Shape{
    //props riêng
    protected double height;
    protected double width;
    //constructor

    //quý cha nên đưa cha lên trước
    public Rectangle(String owner, String color, double height, double width) {
        super(owner, color);
        this.height = height;
        this.width = width;
    }
    //getter

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
    //vá lỗ
    @Override
    public double getPerimeter() {
        return (height + width) * 2;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public void paint() {
        String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|%5.2f|%5.2f"
        , "RECTANGLE", owner, color, width, height, getPerimeter(), getArea());
        System.out.println(str);
    }
    
    
}
