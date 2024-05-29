/*
    Bé Na muốn quản lý hình vuông, tròn, chữ nhật, tam giác, thoi
mà muốn quản lí đống đó thì phải bỏ chúng và cùng một mảng 
nhưng muốn vào cùng một mảng thì phải chứng minh nó cùng một loại. Vậy nên ta 
cùng nhau chứng minh
//kế thừa để về cùng một nhà ==> chung dạng, chung mảng có thể quản lí đc
//muốn trở thành ae thì phải cắt máu ăn thề
*/
package runtime;

import data.Disk;
import data.Rectangle;
import data.Shape;
import data.Square;


public class Program {
    public static void main(String[] args) {
        Shape ds[] = new Shape[5];
        ds[0] = new Disk("Tía", "Purple", 2.0);
        ds[1] = new Rectangle("Hường", "Pink", 2, 3);
        ds[2] = new Square("Anh Sáu", "Green", 5);
        
        Disk d1 = new Disk("Lam", "Blue", 7);
        
    }
    
}
