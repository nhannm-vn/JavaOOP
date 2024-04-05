package data;

public class Square extends Rectangle {

    public Square(String owner, String color, double edge) {
        super(owner, color, edge, edge);
    }
    
    @Override
    public void paint() {
          String str = String.format("Square: %s|%s|%.2f|%.2f|%.2f|%.2f|"
               , owner, color, height, width, getPerimeter(), getArea());
        System.out.println(str);
    }
}
