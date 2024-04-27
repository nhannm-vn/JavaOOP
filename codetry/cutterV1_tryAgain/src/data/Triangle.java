package data;


public class Triangle {
    //props
    protected double edgeA;
    protected double edgeB;
    protected double edgeC;
    
    //tạo cái phểu

    public Triangle(double edgeA, double edgeB, double edgeC) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }
    
    //tạo hàm getter

    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }
    
    //method
    //viết trong class luôn thì không cần nhận vào các props
    public double getPerimeter(){
        return edgeA + edgeB + edgeC;
    }
    
    public double getArea(){
        double P = getPerimeter() / 2;
        return Math.sqrt(P * (P - edgeA) * (P - edgeB) * (P - edgeC));
    }
    
    public void showInfor(){//in ra số thì xài số dương, chữ thì xài âm
        String str = String.format("Triangle    |%5.2f|%5.2f|%5.2f|%5.2f|%5.2f|", 
                                    edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
    
    }
    
    
}
