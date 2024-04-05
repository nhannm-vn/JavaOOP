package data;


public class Rectangle extends Shape {
    protected double height;
    protected double width;

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

    @Override
    public double getPerimeter() {
        return width * 2 + height * 2;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public void paint() {
          String str = String.format("Rectangle: %s|%s|%.2f|%.2f|%.2f|%.2f|"
               , owner, color, height, width , getPerimeter(), getArea());
        System.out.println(str);
    }
    
    
}
