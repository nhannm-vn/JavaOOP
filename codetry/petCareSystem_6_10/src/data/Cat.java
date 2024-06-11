package data;

public class Cat extends Pet{
    //props rieng
    private String ribbon;
    
    //constructor

    public Cat(String id, String owner, String color, double weight, String ribbon) {
        super(id, owner, color, weight);
        this.ribbon = ribbon;
    }
    
    //getter and setter

    public String getRibbon() {
        return ribbon;
    }

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }
    
    //va lo
    
    @Override
    public void showInfor() {
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, ribbon);
        System.out.println(str);
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, ribbon);
    }
    
    
    
}
