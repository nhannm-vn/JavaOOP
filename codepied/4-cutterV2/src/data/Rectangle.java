package data;

//khuôn class in ra hình chữ nhật
public class Rectangle {
    //tạo ngăn properties
    public double edgeA;
    public double edgeB;
    public String color;
    //tạo cái phễu

    public Rectangle(double edgeA, double edgeB, String color) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.color = color;
    }
    
    
    public double getEdgeA(){
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }
     public String getColor() {
        return color;
    }
    //get
    //method
   

    public double perimeter() {
        return edgeA * 2 + edgeB * 2;
    }
    
    public double area(){
        return edgeA * edgeB;
    }
    
    public void showInFor(){
        String  str = String.format("Rectangle: %s|%.2f|%.2f|%.2f|%.2f"
        ,color , edgeA, edgeB, perimeter(), area());
        System.out.println(str);
    }
    
}
