package data;
//class của hình vuông
public class Square extends Rectangle{
    //constructor mới
    //liệt kê các điểm riêng của con
    //k liệt kê gì riêng
    //constructor
    public Square(double edge, String color) {
        super(edge, edge, color);
    }
    
    @Override
    public void paint(){
        String str = String.format("Square: %s|%.2f|%.2f|%.2f|"
        , color, height, getPerimeter(), getArea());
        System.out.println(str);
    }
    
}
