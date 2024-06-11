/*
Cat va Dog dua cho Pet cac thuoc tinh chung sau do no se nhan nguoc lai
 */ 
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
    
    //getter and setter

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    //method showInfor
    //Vi cho va meo co dac diem rieng nen de no tu show ra
    public abstract void showInfor();
    
}
//một con Pet có nhửng thuộc tính owner , color, weight