package runtime;

public class Program {
    public static void main(String[] args) {
        //comment: ghi chú
        //01-datatype
        //trong java co hai dạng datatype
        //1. primitive datatype: kiểu dữ liệu nguyên thủy
        //một vùng nhớ nhỏ được dùng để lưu trữ 1 giá trị
        //vì nó quá nhỏ nên không tách nhỏ ra được nữa
        //1 - byte           1 byte(8bit) số nguyên rất rất nhỏ xài 7 bit còn
        //1 bit để biểu diễn dấu
        //2 - short          2 byte(16bit)số nguyên rất nhỏ
        //3 - int            4 byte(32bit)số nguyên nhỏ
        //4 - long           8 byte       số nguyên lớn
        //5 - float          4 byte       số thực nhỏ
        //6 - double         8 byte       số thực lớn
        //7 - char           2 byte       ký tự 
        //8 - boolean        1 bit        true false
        
        //Giá trị mặc định trong java không phải rác
        //Default value của các biến là 0
        //char là 0 '\0' null
        //boolean 0 là false
        byte numByte = 127; //do số 0 tính dương nên -128 đến 127
        float numFloat = 123.3F;
        
        //int numInt = 259;
        //float numFloat = 123.3 ==> không được
        //Java ưu tiên kiểu số thực là double nên nhìn gì cũng thấy double
        //nên phải ép kiểu float numFloat = 123.3F or f
        //float numF; lưu 0 hoặc 0.0F
        double numDouble = 123.4F;
        //numInt = numByte;
        //numByte = sumInt
        //Không nhét được cái gì quá lớn vào vái gì quá nhỏ
        //2.Object datatype | references datatype
        //là kiểu dữ liệu do người dùng dùng các primitive datatype
        //để định nghĩa
        //Student(name-char-string, yob-int, gpa-float)
        long money = 10_000_000_000L;
        //trong java mặc định hiểu số nguyên là int
        int num1 = 0xFA;//prefix: tiền tố //250
        num1 = 076;//0: prefix octal hệ 8
        //0x: hex
        System.out.println("money: " + money);
        System.out.printf("number 1 nè %d\n", num1);
        System.out.println("number 1 nè " + num1);//line new tự xuống dòng k 
        //canh chỉnh được
        //Operator: toán tử
        //trong Java có ít nhất 10 loại toán tử
        //1.Athrimetic: toán tử toán hạng
        //+ - * / % ++ -- -= += *= /= %=
        int a = 10;
        int b = a++ + ++a - --a - a--;
        System.out.println(b);
        //2.comparision: toán tử so sánh
        // > < <= >= 
        //3.logical
        //and(&&) or(||)
        //&& tìm false gặp false kết luận ngừng luôn
        //|| tìm true thấy true kết luận luôn
        //4.toán tử 3 ngôi
        //5.toán tử một ngôi: unary
        //6.comma: phẩy
        //7.shift bit: toán tử dịch bit
        //<< >>
        int num2 = 8;
        num2 = num2 << 2;
        System.out.println(num2);
        //n >> x: n /  (2^x)
        //n << x: n *  (2^x)
        
        //8.bit wise: (| & ^ ~)
        //|: tìm true số 1
        //&: tìm false số 0
        //^: giống là 0, nghịch là 1
        //~: not, phủ định
        
    }
}
