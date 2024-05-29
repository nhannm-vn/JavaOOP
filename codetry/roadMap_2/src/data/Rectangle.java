/*
Đây là cái khuôn chuyên dùng để đúc ra những hình chữ nhật
 */
package data;

public class Rectangle {
    //properties
    protected String color;
    protected double width;
    protected double height;
    
    //constructor

    public Rectangle(String color, double width, double height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }
    
    //getter

    public String getColor() {
        return color;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    
    //method tính chu vi
    public double getPerimeter(){
        return (height + width) * 2;
    }
    
    //method tính diện tích
    public double getArea(){
        return height * width;
    }
    
    //method showInfor()
    public void paint(){
        String str = String.format("%s|%10s|%5.2f|%5.2f|%5.2f|%5.2f"
                                    , "Rectangle", color, height, width, getPerimeter(), getArea());
        System.out.println(str);
    }
}
