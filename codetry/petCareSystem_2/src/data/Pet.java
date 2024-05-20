/*
Pet là cái khuôn để đúc ra các con Pet và nó có tất cả các thuộc tính chung của 
Cat và Dog
một con Pet có nhửng thuộc tính id, owner , color, weight
 */
package data;

public abstract class Pet {
    //props
    protected String id;
    protected String owner;
    protected String color;
    protected double weight;//vì trong java ta biết số thực được hiểu là double nên
    //để là double cho đễ test code
    
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
    
    //vì mỗi con Dog con Cat sẽ show ra riêng theo đặc điểm riêng của nó nên 
    //ta để cho nó tự định nghĩa
    public abstract void showInfor();
    
}
