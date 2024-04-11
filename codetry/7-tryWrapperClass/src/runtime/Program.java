package runtime;
//wrapper: bao bọc
public class Program {
    public static void main(String[] args) {
        int a = 10;// kiểu dữ liệu primitive datatype(kiểu dữ liệu nguyên thủy)
        //4byte, 32 bit ==> sử dụng 31 bit còn 1 bit làm dấu
        //primitive đc xem là đơn vị nhỏ nhất unit(đơn vị) ==> a không thể tách 
        //nhỏ hơn đc nữa ==> a . cái đầu mày?
        
        //wrapper class
        /*
        Trong java, một wrapper thường được hiểu là một lớp được dùng để bao bọc
        một kiểu dữ liệu cơ bản (primitive datatype) thành một đối tượng (object)
        . Bản chất của các wrapper trong java là cung cấp cách làm việc với kiểu
        dữ liệu nguyên thủy như một đối tượng
        
        */
        Integer b = new Integer(10);
        /*
            Bản chất câu lệnh: gói một số nguyên = 10 vào một object
        ==> cơ chế này gọi là boxing 
        **boxing xảy ra khi mình có wrapper = primitive
        
        Hành động này là gán primitive vào wrapper (đem số 10 nhét vào object)
        **Gọi cái phễu của cái khuôn Integer và bỏ 10 vào khuôn đúc ra được một
        object(heap) sau đó đưa cho con trỏ b (stack) điều khiển sẽ trỏ vào 
        object đó
        
        **Vậy object đc tạo từ Integer có gì bên trong?
        ==> Bức tượng object b đc nhét số 10 vào rồi gói lại(wrapper). Cái cục
        object mà bên trong có core = 10. Ngoài ra trong đó còn có các method
        giúp xử lí số nguyên
        +thằng b sẽ trỏ vào vùng nhớ heap
        +thằng b này sẽ lưu địa chỉ (không hề có kết quả b = 10)
        +thằng b > a rất nhiều vì trong b có nhiều cái đặc biệt
        ==> b có thể . được
        
        */
        System.out.println("a nè: " + a);//10
        System.out.println("b nè: " + b);//đoán là địa chỉ nhưng thực tế là 10
        System.out.println("b nè " + b.toString());//lấy hết giá trị trong object
        
        /*
            Vì hàm sout có một cơ chế là lúc nào cũng gọi hàm toString() mà hàm
        đó có vai trò đi vào trong object lấy ra hết tất cả giá trị trong object
        đó mà thực tế trong object b chỉ có core = 10 nên chỉ in ra được số 10
        (tự động mở hộp lấy số 10 và in ra màn hình) ==> cơ chế auto unboxing
        
        b không bằng 10 | mà chỉ là địa chỉ. In ra được số 10 là do cơ chế 
        auto unboxing của sout. Mặc định gọi toString() và in ra các giá trị 
        prop trong object mà b chỉ có một giá trị duy nhất
        */
        
        int c = b;
        //primitive = wrapper
        //đúng thì c đc gán địa chỉ của con trỏ b đang lưu
        //nhưng may mắn java có cơ chế auto unboxing nên thằng object b mở
        //lõi ra lấy core = 10 đưa cho thằng c
        //==> c. cái đầu mày
        
        //shorthand
        //viết như vậy bản chất của nó cũng đang là wrapper = primitive nên cũng
        //cũng thực hiện cơ chế boxing gói số 2000 vào object
        
        Integer d = 2000;
        System.out.println("d nè: " + d);//2000 auto unboxing
        System.out.println("Sum nè: " + (a + d));//2010 tự động mở ra lấy cộng
        
        d = 2000;//wrapper;
        a = 2000;//primitive
        b = 2000;//wrapper
        
        System.out.println(d == b ? "bằng nhau" : "không bằng nhau");
        //so primitive và primitive thì "==" 
        //so primitive và wrapper thì "==" vì auto unboxing(gặp primitive mở lõi đi ss)
        //so wrapper với wrapper thì so sánh 2 địa chỉ k có (auto unboxing). Nó đang so địa chỉ
        
        //wrapper class muốn so sánh giá trị thì có method riêng
        //so sánh 2 thằng wrapper với nhau phải thông qua hàm nếu k nó sẽ ss đ/c
        System.out.println(d.equals(b));
        System.out.println(b.compareTo(a));//  so sánh 2 giá trị bên trong
        
    }
    
}
