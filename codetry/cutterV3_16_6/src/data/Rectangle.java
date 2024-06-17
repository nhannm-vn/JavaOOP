/*
đây là class đúc ra những hình chữ nhật
 */
package data;

public class Rectangle extends Shape{
    //prop riêng
    protected double edgeA;
    protected double edgeB;
    
    //constructor

    public Rectangle(String owner, String color,
            double edgeA, double edgeB) {
        super(owner, color);
        this.edgeA = edgeA;
        this.edgeB = edgeB;
    }
    
    //getter

    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    @Override
    public double getPerimeter() {
        return 2 * (edgeA + edgeB);
    }

    @Override
    public double getArea() {
        return edgeA * edgeB;
    }

    @Override
    public void showInfor() {
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%6.2f|6.2f|6.2f"
              , "Rectangle", owner, color, edgeA, edgeB, getPerimeter(), getArea());
    }
    
}
