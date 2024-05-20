package data;
/*
Pet là cái khuôn chuyên dùng để đúc ra những con Pet. Nó là class cha của Dog và
Cat. Nó sẽ nắm hết các thuộc tính chung
**một con Pet có nhửng thuộc tính owner , color, weight
*/
public class Pet {
    //props
    protected String id;
    protected String owner;
    protected String color;
    protected double weight;//để double vì trong java hiểu số thực là double nên dễ xài
    
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

    //method showInfor(): giúp tạo ra cái chuỗi đẹp và in ra
    public void showInfor(){
        String str = String.format("%-10s|%-10s|%-10s|%6.2f"
                                    , id, owner, color, weight);
        System.out.println(str);
    }
    
    
}
