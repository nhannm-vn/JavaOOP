package runtime;
//bé na muốn quản lí hình trong, chữ nhật, vuông

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
        ds[3] = d1;
        
        Shape xxx = new Shape("Be Na", "7 color") {
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
                String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f"
                    , "xxx", owner, color, getPerimeter(), getArea());
                System.out.println(str);
            }
        };
        ds[4] = xxx;
        for (Shape item : ds) {
            item.paint();
        }
    }
    
}
