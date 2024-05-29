/*
Shape là cha của mọi loại hình học. Bản chất của các hình kia có thể đứng riêng
lẻ được nhưng khi muốn đưa về cùng một mảng để quản lí thì ta cần một thằng cha
đứng ra giữ các điểm chung của bọn nó
**Cha sẽ cho con hết những gì cha có. Nên cha chỉ lưu những điểm chung của các
con. Nếu cha lưu một đặt tính của riêng một con nào đó(radius) thì các các thằng
con còn lại đều sở hữu radius ==> vô lý
 */
package data;

public abstract class Shape {
    //props chung của bọn nó
    protected String owner;
    protected String color;
    
    //constructor

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
    }
    
    //getter

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }
    
    //hàm tính chu vi. Cha sẽ không định nghĩa vì nếu vậy tất cả đều sẽ như nhau
    public abstract double getPerimeter();
    
    public abstract double getArea();
    
    //hàm in ra thông tin
    public abstract void paint();
    
}
/*
Tại sao không viết công thức cho chu vi vậy?
==>Vì không có công thức chung nào cho tất cả các hình. Nếu ta bỏ một công thức
vào thì các hình phải xài chung. Không phải thằng nào cũng đúng
Tại sao Shape là abtract class vậy
==>Vì nó chứa abstract method
Abstract method là gì vậy?
==>Là một method không được định nghĩa hoặc không có body. Giông cái lỗ trống
mà class là một cái khuôn, một class mà chứa abstract method nghĩa là nó là một
cái khuôn bị thủng
abstract class là một cái khuôn bị thủng ==> không đúc được object còn nếu vá
không được thì thằng con sẽ trở thành abstract class và chờ thằng cháu vá
*/