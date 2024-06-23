package data;

public class Circle extends Shape{
    private double radius;
    
    //constructor

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }
    
    //toString

    @Override
    public String toString() {
        String str = String.format("%2.2f,%2.2f"
                                    , perimeter, area);
        return str;
    }
    
    public void caculateArea(){
        double keyArea = Math.PI * Math.pow(radius, 2);
        setArea(keyArea);
    }
    
    public void caculatePerimeter(){
        double keyPerimeter = 2 * Math.PI * radius;
        setPerimeter(keyPerimeter);
    }
    
}
