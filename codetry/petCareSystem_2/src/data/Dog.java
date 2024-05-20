/*
Dog là cái khuôn chuyên dùng để đúc ra những con chó. Nó có tất cả đặc tính của
Pet và có thêm props necklace
 */
package data;

public class Dog extends Pet{
    //props riêng
    private String necklace;
    
    //constructor
    //quý cha theo đạo nên phải đưa cái chung của cha lên trước
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
    
    //vá lỗ của cha

    @Override
    public void showInfor() {
       //mình tạo ra cái chuỗi đẹp rồi show ra
       String str = String.format("%-15s|%-15s|%-15s|%6.2f|%s"
                                    , id, owner, color, weight, necklace);
        System.out.println(str);
    }
    
    
}
