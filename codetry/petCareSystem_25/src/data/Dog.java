/*
cái khuôn chuyên dùng để đúc ra những con chó
 */
package data;

public class Dog extends Pet{
    //props
    private String necklace;
    
    //constructor

    public Dog(String id, String owner, String color, Double weight, String necklace) {
        super(id, owner, color, weight);
        this.necklace = necklace;
    }

    //getter

    public String getNecklace() {
        return necklace;
    }
    
    //setter

    public void setNecklace(String necklace) {
        this.necklace = necklace;
    }

    @Override
    public void showInfor() {
        String str = String.format("%-7s|%-10s|%-10s|%6.2f|%s"
                                , id, owner, color, weight, necklace);
        System.out.println(str);
    }
    
    //toString

    @Override
    public String toString() {
        String str = String.format("%-7s|%-10s|%-10s|%6.2f|%s"
                                , id, owner, color, weight, necklace);
        return str;
    }
    
    
    
   

    
    
}
