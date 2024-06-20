package data;

public class SpecCar extends Car{
    private int warranty;
    
    //constructor

    public SpecCar() {
    }

    public SpecCar(String name, double price, int warranty) {
        super(name, price);
        this.warranty = warranty;
    }
    
    @Override
    public String toString() {
        String str = String.format("%s,%2.2f,%d"
                            , name.toUpperCase(), price, warranty);
        return str;
    }

    public int getWarranty() {
        if(name.equals("audi")){
            return warranty + 5;
        }else{
            return warranty + 2;
        }
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
    
}
