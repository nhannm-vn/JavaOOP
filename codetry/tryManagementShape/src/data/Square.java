package data;

//class đúc hình vuông
public class Square extends Rectangle {
    //method
    private double edge;
    
    //phểu
    //phểu con nhận sao cũng đc, nhưng phểu cha phải đúng số lượng
    public Square(String owner, String color, double edge) {
        super(owner, color, edge, edge);
    }
    
    //getter

    public double getEdge() {
        return edge;
    }
    
    //method
    @Override
    public void paint() {
        String str = String.format("%s|%s|%s|%.2f|%.2f|%.2f|%.2f|", "Square"
        , owner, color, height, width, getPerimeter(), getArea());
        System.out.println(str);
    }
}
