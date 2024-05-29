/*
Có hai hướng hoặc là extends Shape hoặc là Rectangle

 */
package data;


public class Square extends Rectangle{
    //constructor
    public Square(String owner, String color, double edge) {
        super(owner, color, edge, edge);
    }
    
    @Override
    public void paint() {
        String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|%5.2f|%5.2f"
        , "Square", owner, color, width, height, getPerimeter(), getArea());
        System.out.println(str);
    }
    
    public void drawInFor(){//hàm của riêng thằng con
        System.out.println("Ahihi");
    }   
}
