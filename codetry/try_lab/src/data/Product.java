package data;
public class Product {
    protected String name;
    protected int price;
    
    //constructor

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }
    
    //getter setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String str = String.format("%s,%d"
                                , name, price);
        return str;
    }
    
    
    
}
