/*
Triangle là cái khuôn chuyên dùng dể đúc ra những tam giác thường
 */
package data;

public class Triangle {
    //props
    protected double edgeA;
    protected double edgeB;
    protected double edgeC;
    
    //constructor

    public Triangle(double edgeA, double edgeB, double edgeC) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }
    
    //getter

    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }
    
    
    //tính chu vi tam giác 
    public double getPerimeter(){
        return edgeA + edgeB + edgeC;
    }
    
    //tính diện tích tam giác
    public double getArea(){
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - edgeA) * (p - edgeB) * (p - edgeC));
    }
    
    //show thông tin ra
    public void showInfor(){
        String str = String.format("%s|%5.2f|%5.2f|%5.2f|%5.2f|%5.2f"
                        , "Triangle", edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
    }
}
