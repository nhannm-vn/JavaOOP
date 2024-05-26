/*
một con Pet có nhửng thuộc tính owner , color, weight
 */
package data;

public abstract class Pet {
    //props
    protected String id;
    protected String owner;
    protected String color;
    protected Double weight;//chọn double vì dễ test code
    
    //constructor

    public Pet(String id, String owner, String color, Double weight) {
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

    public Double getWeight() {
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

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    //hàm in ra thông tin để cho mỗi thằng tự định nghĩa
    public abstract void showInfor();
    
}
