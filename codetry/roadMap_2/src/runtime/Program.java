/*
//Bé na muốn quản lý tiếp
//Bé na muốn lưu hình vuông và hình chữ nhật
//và hình tròn

 */
package runtime;

import data.Disk;
import data.Rectangle;
import data.Square;

public class Program {
    public static void main(String[] args) {
        Rectangle re1 = new Rectangle("Tím", 2, 5);
        Square sq1 = new Square("Đỏ", 3);
        Rectangle sq2 = new Square("Vàng", 2);
        
        Rectangle ds[] = new Rectangle[3];
        ds[0] = sq1;
        ds[1] = re1;
        ds[2] = sq2;
        
        for (Rectangle item : ds) {
            item.paint();
        }
        
        Disk d1 = new Disk("Vàng", 3);
        d1.paint();
    }
    
}
