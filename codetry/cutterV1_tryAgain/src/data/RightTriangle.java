package data;

//class để quản lí hình tam giác vuông
//nhận class Triangle làm cha để nhận được các thuộc tính của nó
public class RightTriangle extends Triangle {
    //các prop đều giống của cha
    //tạo ra constructor mới
    public RightTriangle(double edgeA, double edgeB) {//muốn đầu vào của con mấy cái thì tự chỉnh
        super(edgeA, edgeB, Math.sqrt(edgeA * edgeA + edgeB * edgeB));//chỗ này là phểu của cha
    }
    //các biến khi xài bên program thì mình điều chỉnh được
    //chứ các biến của thằng Triangle có sẵn thì phải giữ nguyên
    
    //các hàm tính toán thì y chang của cha
    
    //độ lại hàm showInfor()
    @Override
    public void showInfor(){//in ra số thì xài số dương, chữ thì xài âm
        String str = String.format("RightTriangle    |%5.2f|%5.2f|%5.2f|%5.2f|%5.2f|", 
                                    edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
    
    }
}
