package data;

//khuôn Rectangle
/*
    Rectangle kế thừa cha để lấy lại những gì nó đã gửi lên cho ổng. Giúp
nó khôi phục trạng thái ban đầu như lúc chưa kế thừa
**Các bước để tiếp nhận kế thừa
0. Tạo class con
1. Khai báo đặc tính của riêng con
2. Cho con nhận cha thông qua extends Shape
3. Tạo constructor
4. Giao cho phần việc để làm (nếu có)
bổ súc code cho các abstract của cha(vá lỗ)
độ lại hàm cho con phù hợp
*/
public class Rectangle extends Shape {
    protected double height;
    protected double width;
    
    //constructor
    //owner và color vốn k thuộc Rectangle. Mà nó chỉ thừa hưởng thôi nên viết
    //ngược lại
    public Rectangle(String owner, String color, double height, double width) {
        super(owner, color);//super chỉ đc đặt ở đầu
        this.height = height;
        this.width = width;
    }
    //chứng tỏ con chính là cha cộng với phần riêng

    //vá lỗ
    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void paint() {
        String str = String.format("Rectangle: %s|%s|%.2f|%.2f|%.2f|%.2f",
                owner, color, width, height, getPerimeter(), getArea());
        System.out.println(str);
    }
    
    
    
}
