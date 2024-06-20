package data;

public class Car {
    //props
    protected String name;
    protected double price;
    
    //constructor

    public Car() {
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String str = String.format("%10s,%4.2f"
                            , name, price);
        return str;
    }
    
    
}
