package runtime;

import data.Disk;
import data.Rectangle;
import data.Shape;
import data.Square;

public class Program {
    public static void main(String[] args) {
    /*
    Bé Na muốn quản lí hình vuông, tròn, chữ nhật 
    mà muốn quản lí đống đó thì phải bỏ chúng vào cùng một mảng. Nhưng muốn vào cùng
    một mảng thì phải chứng minh nó cùng một loại vậy nên ta cùng nhau chứng minh
    
    Cần có một thằng đứa ra đại diện làm cha 
    */
    //các đặc điểm chung của chúng là owner, color, getPerimeter(), getArea(), paint()
        
    //tạo cái mảng để lưu các hình
        Shape ds[] = new Shape[5];
        ds[0] = new Rectangle("Hường", "Pink", 2, 3);
        ds[1] = new Disk("Tía", "Purple", 2.0);
        
        ds[2] = new Square("Anh Sáu", "Green", 5);
    
        Disk d1 = new Disk("Lam", "Blue", 7);
        
        ds[3] = d1;
        
        //quản lí một hình lạ không biết tên, không muốn nói, lười
        //xài anonymous mượn gió bẻ măng, vừa vá cừa đổ
        
        Shape xxx = new Shape("bé Na", "7 màu") {
            @Override
            public double getPerimeter() {
                return 50;
            }
            
            @Override
            public double getArea() {
                return 15;
            }
            
            @Override
            public void paint() {
                String str = String.format("%s|%s|%s|%.2f|%.2f|", "xxx"
                , owner, color, getPerimeter(), getArea());
                System.out.println(str);
            }
        };
        ds[4] = xxx;
        
        //in ra các thông tin
        for (Shape item : ds) {
            item.paint();
        }
    }
    
}
