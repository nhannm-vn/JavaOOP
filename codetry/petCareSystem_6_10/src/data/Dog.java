package data;

public class Dog extends Pet{
    //prop rieng
    private String necklace;
    
    //constructor

    public Dog(String id, String owner, String color, double weight, String necklace) {
        super(id, owner, color, weight);
        this.necklace = necklace;
    }
    
    //getter and setter

    public String getNecklace() {
        return necklace;
    }

    public void setNecklace(String necklace) {
        this.necklace = necklace;
    }

    //va lo
    @Override
    public void showInfor() {
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, necklace);
        System.out.println(str);
    }
    
    //toString

    @Override
    public String toString() {
        return String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, necklace);
    }
    
    
    
}
