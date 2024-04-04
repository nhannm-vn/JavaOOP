package data;

//khuôn class in ra hình chữ nhật
//Square is a Rectangle
//con         cha
public class Rectangle {
    //tạo ngăn properties
    protected double height;
    protected double width;
    protected String color;
    //tạo cái phễu
    
    public Rectangle(double height, double width, String color) {
        this.height = height;
        this.width = width;
        this.color = color;
    }
   
    //get
    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }
    
    //method
    public double getPerimeter(){
        return height*2 + width*2;
    }
    public double getArea(){
        return height*width;
    }
    
    public void paint(){
        String str = String.format("Rectangle: %s|%.2f|%.2f|%.2f|%.2f|"
        , color, height, width, getPerimeter(), getArea());
        System.out.println(str);
    }

    
}
