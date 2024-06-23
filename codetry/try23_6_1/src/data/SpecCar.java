package data;

public class SpecCar extends Car{
    //pros
    private int warranty;
    
    //contructor

    public SpecCar() {
    }

    public SpecCar(String name, double price, int warranty) {
        super(name, price);
        this.warranty = warranty;
    }
    
    //getter and setter

    public int getWarranty() {
        if(name.equals("AUDI")){
            return warranty + 5;
        }else{
            return warranty + 2;
        }
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
    
    //toString

    @Override
    public String toString() {
        String str = String.format("%s,%2.2f,%d", getName(), price, warranty);
        return str;
    }
    
    
}
