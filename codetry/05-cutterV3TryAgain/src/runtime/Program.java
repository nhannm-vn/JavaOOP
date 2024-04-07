package runtime;

//bé na muốn quản lí lần lượt hình vông, chữ nhật, tròn

import data.Disk;
import data.Rectangle;
import data.Shape;
import data.Square;

//tạo ra một class Shape chung để quản lí lần lượt ba thằng
public class Program {
    public static void main(String[] args) {
        Shape ds[] = new Shape[5];
        
        ds[0] = new Disk("Tía", "Purple", 2.0);
        ds[1] = new Rectangle("Hường", "Pink", 2, 3);
        ds[2] = new Square("Anh Sáu", "Green", 5);
        
        Disk d1 = new Disk("Lam", "Blue", 7);
        ds[3]  = d1;
        
        //Một hình mà không ai biết
        Shape xxx = new Shape("Bé Na", "7 màu") {
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
                String str = String.format("%s|%s|%s|%.2f|%.2f"
                    , "xxx", owner, color, getPerimeter(), getArea());
                System.out.println(str);
            }
        };
        
        ds[4] = xxx;
        
        for (Shape item : ds) {
            item.paint();
        }
        
        //tạo rectangle bằng phễu square
        Rectangle r1 = new Square("Bông", "Tím", 4);
        //nó chỉ lấy tới paint của thằng square vì bị override rồi
        
        Square tmp = (Square)r1;
        tmp.paint();
    }
    
}
