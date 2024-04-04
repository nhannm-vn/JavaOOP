package data;

//khuôn đúc ra tam giác
//Right Triangle is Triangle
//con                cha
public class Triangle {
    //tạo cái ngăn
    protected double edgeA;
    protected double edgeB;
    protected double edgeC;
    //Tạo cái phễu

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
    //method
    public double getPerimeter(){
        return edgeA + edgeB + edgeC;
    }
    
    public double getArea(){
        double p = (edgeA + edgeB + edgeC) / 2;
        return Math.sqrt(p * (p - edgeA) * (p - edgeB) * (p - edgeC));
    }
    
    public void paint(){
        String str = String.format("Triangle: %.2f|%.2f|%.2f|%.2f|%.2f",
                edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
    }
}
