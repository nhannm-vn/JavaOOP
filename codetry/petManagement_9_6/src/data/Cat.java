/*
Class chuyen dung de duc ra nhung con meo
 */
package data;

public class Cat extends Pet{
    //props
    private String ribbon;
    
    //constructor

    public Cat(String id, String owner, String color, double weight, String ribbon) {
        super(id, owner, color, weight);
        this.ribbon = ribbon;
    }
    
    //getter
    
    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }

    public String getRibbon() {
        return ribbon;
    }
    //vá lỗ showInfor()
    @Override
    public void showInfor() {
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
