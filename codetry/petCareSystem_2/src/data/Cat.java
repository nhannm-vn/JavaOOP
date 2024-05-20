/*
Cat là cái khuôn chuyên dùng để đúc ra những con mèo. Nó có tất cả đặc tính của
Pet và có thêm props ribbon
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
    
    //vá lỗ
    @Override
    public void showInfor() {
       //mình tạo ra cái chuỗi đẹp rồi show ra
       String str = String.format("%-15s|%-15s|%-15s|%6.2f|%s"
                                    , id, owner, color, weight, ribbon);
        System.out.println(str);
    }
    
}
