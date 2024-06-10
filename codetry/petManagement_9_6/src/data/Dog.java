/*
Class chuyên dùng để đúc ra những con chó
 */
package data;

public class Dog extends Pet{
    //prop riêng
    private String neckLace;
    
    //constructor

    public Dog(String id, String owner, String color, double weight, String neckLace) {
        super(id, owner, color, weight);
        this.neckLace = neckLace;
    }
    
    //getter
    
    public void setNeckLace(String neckLace) {
        this.neckLace = neckLace;
    }

    public String getNeckLace() {
        return neckLace;
    }
    //vá lỗ showInfor()
    @Override
    public void showInfor() {
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, neckLace);
        System.out.println(str);
    }
    
    //toString

    @Override
    public String toString() {
        String str = String.format("%-10s|%-10s|%-10s|%6.2f|%s"
                                    , id, owner, color, weight, neckLace);
        return str;
    }
    
    
    
}
