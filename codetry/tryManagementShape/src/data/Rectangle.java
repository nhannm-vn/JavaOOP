package data;

//khuôn cho Rectangle
public class Rectangle extends Shape {
    //props riêng
    protected double height;
    protected double width;
    
    //cái phểu

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
    
    //method vá lỗ, tự định nghĩa

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
        String str = String.format("%s|%s|%s|%.2f|%.2f|%.2f|%.2f|", "Rectangle"
        , owner, color, height, width, getPerimeter(), getArea());
        System.out.println(str);
    }
    
    
}
