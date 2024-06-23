package data;

public class Car {
    //prop
    protected String name;
    protected double price;
    
    //constructor

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Car() {
    }
    
    //getter

    public String getName() {
        return name.toUpperCase();
    }

    public double getPrice() {
        return price;
    }
    
    //toString

    @Override
    public String toString() {
        String str = String.format("%s,%2.2f", name, price);
        return str;
    }
    
    
}
