package runtime;
//Bé na muốn quản lý tiếp
//Bé na muốn lưu hình vuông và hình chữ nhật

import data.Disk;
import data.Rectangle;
import data.Square;


//Square is a Rectangle
//con          cha 
public class Program {
    //hình chữ nhật(color, ...các cạnh)
    public static void main(String[] args) {
        Rectangle re1 = new Rectangle(2, 5, "Tím");
        Square sq1 = new Square(3, "Đỏ");
        Rectangle re2 = new Square(2, "Vàng");
        
        //Square sq2 = new Rectangle(0, 0, color)
        //Này không được
        /*
        Khai cha new con thì bình thường(vì con có các thuộc tính của cha)
        Khai con mà new cha thì không được
        **Vì em không thể là con có trước con tạo ra cha được
        */
        /*
        Square ds[] = new Square[3];
        ds[0] = sq1;
        ds[1] = re1;
        ds[2] = re2;
        Mảng hình vuông sao nhét hình chữ nhật vô đc. Vì hình chữ nhật kp hv
        */
        Rectangle ds[] = new Rectangle[3];//vì hv cũng là hình chữ nhật
        ds[0] = sq1;
        ds[1] = re1;
        ds[2] = re2;
        /*
        for(int i = 0; i <= ds.length - 1; i++){
            ds[i].paint();
        }*/
        for (Rectangle item : ds) {
            item.paint();
        }
        
        Disk d1 = new Disk("Vàng", 3);
        //new Disk là gọi cái phễu của class Disk 
        //nhận dữ liệu vào từng ngăn của class
        //tạo ra object r đưa cho con trỏ d1
    }
    
    
}
