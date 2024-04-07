package data;

//khuôn đúc ra hình chữ nhật
public class Rectangle extends Shape {
    protected double height;
    protected double width;
    
    //tạo cái phễu riêng
    //đặc tính chung tất cả đều có thì đưa lên đầu
    public Rectangle(String owner, String color, double height, double width) {
        super(owner, color);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
    
    //method

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public void paint() {
        String str = String.format("Rectangle:   %s|%s|%.2f|%.2f|%.2f|%.2f|", owner, 
                color, height, width, getPerimeter(), getArea());
        System.out.println(str);
    }
    
   
}
