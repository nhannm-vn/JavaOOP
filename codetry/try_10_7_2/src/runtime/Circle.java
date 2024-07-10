package runtime;


public class Circle extends Shape{
    private double radius;

    public Circle() {
    }

    public Circle(double value) {
        if(value < 0){
            this.radius = 0.5;
        }
        this.radius = value;
    }
    @Override
    public String toString() {
        caculateArea();
        caculatePerimeter();
        String str = String.format("%.2f, %.2f"
                , perimeter, area);
        return str;
    }
 
    public void caculateArea(){
        area = Math.PI * Math.pow(radius, 2);
    }
    
    public void caculatePerimeter(){
        perimeter = 2 * Math.PI * radius;
    }
}
