/*
//Bé Na học lớp 5 
//Bé Na cần lưu rất nhiều hình tam giác có đủ loại
để lưu các hình tam giác khác nhau ta cần đưa nó vào chung một mảng
RightTriangle is a Triangle
 */
package runtime;

import data.RightTriangle;
import data.Triangle;

public class Program {
    public static void main(String[] args) {
        Triangle ds[] = new Triangle[4];
        ds[0] = new Triangle(4, 7.5, 10);
        ds[1] = new RightTriangle(3, 4);
        ds[0].showInfor();
        ds[1].showInfor();
        
    }
    
}
