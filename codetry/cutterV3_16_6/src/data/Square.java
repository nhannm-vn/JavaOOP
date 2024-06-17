/*
hình chữ nhật
 */
package data;

public class Square extends Rectangle{
    //constructor
    public Square(String owner, String color, double edgeA) {
        super(owner, color, edgeA, edgeA);
    }
    
    //showInfor
    @Override
    public void showInfor() {
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%6.2f|6.2f|6.2f"
              , "Square", owner, color, edgeA, edgeB, getPerimeter(), getArea());
    }

}
