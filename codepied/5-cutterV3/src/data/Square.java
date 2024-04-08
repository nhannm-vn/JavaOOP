package data;

//Có hai hướng để giải quyết
/*
    1.Nhận Square làm cha và y chang 2 thằng kia rồi vá 3 lỗ.
    2.Nhận Reactangle làm cha. Không cần vá lỗ thủng do Rectangle vá rồi
*/
public class Square extends Rectangle {
    //tạo phễu
    public Square(String owner, String color, double edge) {
        super(owner, color, edge, edge);
    }
    @Override
    public void paint() {//edge chỉ là giá trị người dùng đưa vào chứ k có biến edge
        String str = String.format("Square: %s|%s|%.2f|%.2f|%.2f",
                owner, color, height, getPerimeter(), getArea());
        System.out.println(str);
    }
    public void drawInFor(){//hàm của riêng thằng con
        System.out.println("ahihi");
    }
}
