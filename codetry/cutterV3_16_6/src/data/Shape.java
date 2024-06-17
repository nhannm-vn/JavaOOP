/*
Shape là cha của mọi loiaj hình học. Mấy thằng kia vì muốn có thể về chung một mảng
để có thể quản lí được nên đưa các thông tin chung cho th ch giữ. Sau đó kế
thừa th cha để nhận ngược lại
 */
package data;
public abstract class Shape {
    //props chung
    protected String owner;
    protected String color;
    
    //constructor

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
    }
    
    //getter and setter

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }
    
    /*
    Vì các hình thì có công thức tính chu vi cùng như diện tích riêng nên ta khôg
    thể bỏ một công thức cụ thể vào được vì nếu như vậy thì thằng nào khi kế thừa cũng
    phải xài một công thức cố đinh. Vì vậy ta để abstract để chúng nó tự định nghĩa
    */
    //method tính chu vi
    public abstract double getPerimeter();
    //method tính diện tích 
    public abstract double getArea();
    
    //method showInfor
    public abstract void showInfor();
}
