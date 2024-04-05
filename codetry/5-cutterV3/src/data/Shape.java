package data;


public abstract class Shape {
    protected String owner;
    protected String color;

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }
    
    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract void paint();
}
