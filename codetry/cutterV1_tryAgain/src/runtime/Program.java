package runtime;
//Bé Na học lớp 5 
//Bé Na cần lưu rất nhiều hình tam giác có đủ loại

import data.RightTriangle;
import data.Triangle;

//đầu tiên cần xác định coi đâu là cha đâu là con thông qua quan hệ is-a
//Rectangle is a Triangle
//con               cha
//tạo class của thằng cha trước để dễ làm việc
public class Program {
    public static void main(String[] args) {
        Triangle ds[] = new Triangle[3];
        Triangle t1 = new Triangle(4, 7.5, 10);
        RightTriangle r1 = new RightTriangle(3, 4);
        RightTriangle r2 = new RightTriangle(6, 8);
        ds[0] = t1;
        ds[1] = r1;
        ds[2] = r2;
        // in ra các hình trong danh sách
        for (Triangle item : ds) {
            item.showInfor();
        }
        
    }
    
}
