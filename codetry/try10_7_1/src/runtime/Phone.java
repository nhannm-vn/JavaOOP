package runtime;

public class Phone {
    private int id;
    private String name;
    private double unitPrice;
    private int quantity;
    private boolean status;

    public Phone() {
    }

    public Phone(int id, String name, double unitPrice, int quantity, boolean status) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public String getName() {
        return name.toUpperCase();
    }
    
    public double subTotal(){
        double sub;
        sub = quantity * unitPrice;
        if(name.substring(0, 1).matches("^(s|S)$")){
            sub =  sub * 0.90;
        }
        String str = String.format("%.2f", sub);
        double result = Double.parseDouble(str);
        return result;
    }

    @Override
    public String toString() {
        String str;
        if(status == true){
            str = String.format("%d,%s,%.2f,%d,%.2f,%s"
                    , id, getName(), unitPrice, quantity, subTotal(), "Available");
        }else{
            str = String.format("%d,%s,%.2f,%d,%.2f,%s"
                    , id, getName(), unitPrice, quantity, subTotal(), "Unavailable");
        }
        return str;
    }
    
    
}
