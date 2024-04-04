package data;
/*
    Shape là cha của mọi loại hình học. Bản chất các hình tròn, vuông, chữ nhật
.. có thể tồn tại độc lập mà không cần nhận cha-con nhưng như v thì chúng k về 
cùng một nhà dc(mảng) ==> không quản lí đc
Vậy nên chúng mới tìm và tạo ra một thằng cha để chứng minh mình có cùng một 
chủng loại và về chung một mảng
**Cha sẽ cho con tất cả những gì cha có. Nên cha chỉ lưu những điểm chung của 
các con. Nếu cha lưu một đặt tính của riêng một con nào đó. Ví dụ radius thì các
thằng con còn lại đều sở hữu radius ==> vô lý
*/
public abstract class Shape {//một class chứa abstract 
    //method thì chắc chắn abtract class
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
    //nó không định nghĩa đc thì để mấy thằng khác định nghĩa
    //nếu bỏ công thức vô là mấy th kia xài chung bậy
    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract void paint();
    
}
/*
    TOP CÂU HỎI PHỎNG VẤN
+Tại sao không viết công thức cho chu vi vậy?
==> Vì không có công thức chung nào cho tất cả các hình. Nếu bỏ một công thức
vào thì tất cả phải xài chung và không phải hình nào cx đúng
+Tại sao Shape là abstract class vậy?
==> Vì nó chứa abstract method 
+abstract method là gì vậy?
==> Là một method không được định nghĩa, không có body, GIỐNG NHƯ MỘT LỖ THỦNG
mà class là một cái khuôn. Một class mà chứa abstract method nghĩa là nó là cái
khuôn bị thủng ==> abstract class bản thân là một cái khuôn bị thủng. Nên không
rót nguyên liệu vào để đúc được

*Vậy abstract class cần làm gì?
==>Sẽ tìm một class con của nó, và nhờ thằng con vá cho mình những lỗ thủng đó
. Nếu vá được thì thằng con sẽ có thể đúc ra object

class Shape
    abs double getPerimeter()
    abs double getArea()
    abs void paint()
//Tại sao phải viết vô đây. Để đây ép buộc tất cả các thằng con phải tính chu vi
, diện tích. Còn tính như nào thì tao không biết và không áp cho tụi bây đc.
bởi vậy tao là abstract

class Rectangle extends Shape(){
    double getPerimeter() (r+d)*2
    double getArea()   r * d
    void paint()  dssasas
}

//nếu mà rectangle vá không đc thì sẽ truyền thế hệ sau. Rồi truyền tới khi
nào vá đc thì thôi. Cha k đc tới con rồi tới cháu (class Square)

*/