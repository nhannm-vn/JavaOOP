/*
Pet là class cha giúp cho Dog và Cat có thể về chung một nhà
Hai con sẽ đưa cha giữ. Sau đó 2 thằng con nhận cha và có ngược lại
 */
//một con Pet có nhửng thuộc tính owner , color, weight
package data;

public abstract class Pet {
    protected String id;
    protected String owner;
    protected String color;
    protected double weight;
    
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
    public void setId(String id) {    
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //setter
    public void setWeight(double weight) {    
        this.weight = weight;
    }

    /*
    method showInfor()giúp tạo ra cái chuỗi đẹp và in ra nó
    Vì con chó thì có necklace còn con mèo thì có ribbon nên showInfor không có
    công thức chung cụ thể cho nó
     */
    //in ra như thế nào phải để thằng con tự quyết định
    public abstract void showInfor();
}
