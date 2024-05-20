/*
Dog là cái khuôn chuyên dùng để đúc ra Dog

 */
package data;

public class Dog extends Pet{
    //props riêng
    private String necklace;
    
    //constructor
    //đưa thuộc tính của cha lên đầu

    public Dog(String id, String owner, String color, double weight, String necklace) {
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
    
    //độ lại hàm của cha
    @Override
    public void showInfor(){
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, necklace);
        System.out.println(str);
    }
    
}
