package runtime;
//Bé na muốn quản lý tiếp
//Bé na muốn lưu hình vuông và hình chữ nhật

import data.Rectangle;
import data.Square;



//Square is Rectangle
public class Program {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(2, 5, "Tím");
        rec1.showInFor();
        Square sq1 = new Square(3, "Đỏ");
        sq1.showInFor();
    }
}
