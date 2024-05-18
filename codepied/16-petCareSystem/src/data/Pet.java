/*
Pet là cái class chung giúp Dog và Cat có thể vào chung mảng đc
 */
package data;

public abstract class Pet {
    //props
    protected String id;
    protected String owner;
    protected String color;
    protected double weight;//lí do là double là vì số thực trong java mặc định là double 
    //nên khi tải giá trị vào thì phải ép thêm chữ F để về float
    
    //constructor

    public Pet(String id, String owner, String color, double weight) {
        this.id = id;
        this.owner = owner;
        this.color = color;
        this.weight = weight;
    }
    
    //getter

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }
    //setter

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    /*
    method showInfor()giúp tạo ra cái chuỗi đẹp và in ra nó
    Vì con chó thì có necklace còn con mèo thì có ribbon nên showInfor không có
    công thức chung cụ thể cho nó
    */
    public abstract void showInfor();
            
}
