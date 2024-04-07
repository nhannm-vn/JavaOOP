package data;

//Shape là cha chung có những đặc tính của mấy thằng kia
public abstract class Shape {
    //đặc điểm chung mà ba thằng kia đều có
    protected String owner;
    protected String color;
    
    //tạo cái phễu

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
    }
    
    //getter

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }
    
    //method
    public abstract double getPerimeter();//không đc định nghĩa
    public abstract double getArea();
    public abstract void paint();
}
