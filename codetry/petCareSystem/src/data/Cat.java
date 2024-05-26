/*
Cái khuôn chuyên dùng để đúc ra Cat
 */
package data;

public class Cat extends Pet{
    //props riêng
    private String ribbon;
    
    //constructor

    public Cat(String id, String owner, String color, double weight, String ribbon) {
        super(id, owner, color, weight);
        this.ribbon = ribbon;
    }

    
    
    //getter

    public String getRibbon() {
        return ribbon;
    }
    
    //setter

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }
    
    //độ lại hàm của cha
    @Override
    public void showInfor(){
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, ribbon);
        System.out.println(str);
    }

    @Override
    public String toString() {
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, ribbon);
        return str;
    }
    
    
}
