package data;


public class Disky {
    private String color;
    private double r;

    public Disky(String color, double r) {
        this.color = color;
        this.r = r;
    }

    public String getColor() {
        return color;
    }

    public double getR() {
        return r;
    }
    
    public double getPerimeter(){
        return 2 * Math.PI * r;
    }
    public double getArea(){
        return Math.pow(r, 2) * Math.PI;
    }
    
    public void paint(){
        String str = String.format("Disk:   %5s|%5.2f|%5.2f|%5.2f", 
                color, r, getPerimeter(), getArea());
        System.out.println(str);
    }
}
