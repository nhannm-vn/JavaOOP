package data;
/*
Cái khuôn để đúc ra những con chó
*/
public class Dog extends Pet{
    //props
    private String necklace;
    
    //constructor

    public Dog(String id, String owner, String color, double weight, String necklace) {
        super(id, owner, color, weight);
        this.necklace = necklace;
    }
    
    //getter

    public String getNecklace() {
        return necklace;
    }
    
    @Override
    public void showInfor() {
        String str = String.format("%7s|%-12s|%-12s|%6.2f|%s"
                                , id, owner, color, weight, necklace);
        System.out.println(str);
    }
    
    //toString() trả ra cái chuỗi
    //override thủy tổ Object

    @Override
    public String toString() {//tạo ra chuỗi đẹp và trả ra chuỗi
        String str = String.format("%7s|%-12s|%-12s|%6.2f|%s"
                                , id, owner, color, weight, necklace);
        return str;
    }
    
    
    
    
    
}
