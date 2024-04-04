package data;

public class RightTriangle extends Triangle{//tam giác vuông là phiên bản mr tg
    //viết lại phễu
    //Là cái khuôn chuyên dùng để đúc ra tam giác vuông
    //Bây giờ tao phát hiện ra bọn này giống nhau lăm. Có thể chúng có mối
    //quan hệ huyết thống is-a
    /*
        Triangle - RightTriangle
        RigheTriangle is a Triangle
        con           -      cha
    */
    //xác định cha-con thông qua is-a
    //Tại sao phải nhận cha: bản chất RightTriangle không nhận cha có bthgkhông?
    //==> bthg nhưng mệt lắm ó
    //1. Những gì cha làm tốt rồi thì mình lấy xài, k viết lại
    //2. Muốn nhận cha con xài extends: mở rộng
    public RightTriangle(double edgeA, double edgeB) {//này là constructor con
        super(edgeA, edgeB, Math.sqrt(edgeA * edgeA + edgeB * edgeB));
        //này là constructor của cha
        
    }
    //super là ám chỉ bề trên. Muốn đúc thằng con phải đúc thằng cha trước
    //muốn tạo thằng con phải tạo thằng cha trước
    //độ lại method
    @Override//tôi độ lại hàm của bố tôi cho phù hợp với tôi
    public void showInFor(){
        String str = String.format("RightTriangle: %.2f|%.2f|%.2f|%.2f|%.2f|"
                , edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
    }
/*
    +Ta có hai class cha con. Có nghĩa là con sẽ kế thừa hết những gì cha có 
    class con > class cha || do nó là phiên bản mở rộng của ổng. Trong 
    constructor của con có constructor của cha nó. 
    ==> tức là muốn tạo ra con thì phải tạo ra cha trước. Trong con có cha
    ==> con lớn hơn cha
    *Override là hiện tượng chỉ xuất hiện trong mối quan hệ cha con(is-a)
    khi thằng con muốn độ lại method của thằng cha nó tạo ra một method có tên
    giống với method của cha (giống hoặc khác parametor)
    
    *Overload là hiện tượng diễn ra không cần mối quan hệ. Khi method này 
    giống method kia chỉ khác parametor
    
*/
    
}