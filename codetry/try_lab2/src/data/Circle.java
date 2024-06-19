package data;

public class Circle extends Shape{
    //props
    private double radius;
    
    //constructor

    public Circle() {
    }
    

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        String str = String.format("%4.2f,%4.2f"
                                   , perimeter, area);
        return str;
    }
    
    public void calculateArea(){
        setArea(Math.PI * Math.pow(radius, 2));
    }
    
    public void calculatePerimeter(){
        setPerimeter(2 * Math.PI * radius);
    }
}
