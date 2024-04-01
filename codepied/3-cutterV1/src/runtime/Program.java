package runtime;
//bạn Na muốn in ra hàng loạt tam giác thường và vuông
//RightTriangle is Triangle
//Bé Na cần lưu rất nhiều hình tam giác có đủ loại
import data.RightTriangle;
import data.Triangle;


public class Program {
    public static void main(String[] args) {
        Triangle tr1 = new Triangle(4, 7.5, 10);
        tr1.showInFor();
        
        RightTriangle rt1 = new RightTriangle(3, 4);
        rt1.showInFor();
    }
   
}
