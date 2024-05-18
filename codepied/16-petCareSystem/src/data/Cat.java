package data;
/*
Cái khuôn để đúc ra những con mèo
*/
public class Cat extends Pet{
    //props
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
    
    
    @Override
    public void showInfor() {
        String str = String.format("%7s|%-12s|%-12s|%6.2f|%s"
                                , id, owner, color, weight, ribbon);
        System.out.println(str);
    }
    
    @Override
    public String toString() {//tạo ra chuỗi đẹp và trả ra chuỗi
        String str = String.format("%7s|%-12s|%-12s|%6.2f|%s"
                                , id, owner, color, weight, ribbon);
        return str;
    }
    
}
