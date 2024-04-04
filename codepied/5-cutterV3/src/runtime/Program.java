package runtime;

import data.Disk;
import data.Rectangle;
import data.Shape;
import data.Square;



/*
    Bé Na muốn quản lí hình vuông, tròn, chữ nhật, tam giác, hình thoi
mà muốn quản lí đống đó thì phải bỏ chúng vào cùng một mảng. Nhưng muốn vào cùng
một mảng thì phải chứng minh nó cùng một loại vậy nên ta cùng nhau chứng minh

//kế thừa để về chung một nhà ==> tụi mình là ae ==> chung một dạng ==> quản lí
đc
//quy luật nhận cha con ae ==> 3 thằng này phải cắt máu ăn thề
//điểm chung owner, color, getParameter, getArea
//nếu là con tao thì đưa hết điểm chung cho tao giữ sau đó tao truyền lại cho
*/
public class Program {
    public static void main(String[] args) {
        //tạo mảng để lưu tất cả các hình học
        Shape ds[] = new Shape[5];
        ds[0] = new Rectangle("Hường", "Pink", 2, 3);
        ds[1] = new Disk("Tía", "Purple", 2.0);
        ds[2] = new Square("Anh Sáu", "Green", 5);
        
        Disk d1 = new Disk("Lam", "Blue", 7);
        //Tạo ra đối tượng rồi đưa cho d1 điều khiển
        ds[3] = d1;
        //2 chàng trỏ 1 nàng
    /*
        **Muốn tạo ra một object thì ta cần chuẩn bị gì?
        1. Cái khuôn(class)
        2. Cái phễu(constructor)
        3. Tạo biến con trỏ (ví dụ: d1)
        ví dụ: Dog chiquaqua = new Dog(?, ?, ?)
        gọi cái phễu để rót nguyên liệu vào cái khuôn dog sau đó đưa cho 
        chioquaqua điều khiến 
        nếu anh có class con thì object đc tạo ra có giống như trên không?
        ==> vẫn giống vậy
        vd: Square sq1 = new Square(?,?,?)
        
        **Tuy nhiên nếu mình nhìn nhận vào sâu bên trong vùng nhớ của con. Ta sẽ
        thấy rằng có một đặc điểm là vùng new con sẽ chứa vùng new cha(super)
        +Giúp thằng con có hết tất cả những gì cha có. Bản thân th con có thể
        độc lập nhưng vì nhận cha nên đã đưa cho các phần chung. KẾ THỪA LÀ 
        TRẠNG THÁI GIÚP KHÔI PHỤC NHỮNG GÌ ĐÃ MẤT BAN ĐẦU 
        +Thừa hưởng những gì người khác đã làm tốt rồi
        
        Square = new Square();
            new Rectangle + hàm của riêng con(Override)
        con = new cha + con của riêng con
              inherit   +   extends(vùng biến dị mở rộng)
              super
              kế thừa
              duy truyền
        
        **Một object đc tạo từ abstract class:
        nó = new cha + code riêng con + code vá lỗ thủng
        mình hiểu rằng abstract class là một cái khuôn bị thủng
        muốn tạo object phải thông qua 1 class trung gian 
        cụ thể Rectangle, Square, Disk
        
        **Nếu muốn tạo object từ abstract class mà k thông qua class trung gian
        vì vười, vì không biết đặt tên gì, không dám nói tên. Thì có thể dùng
        kĩ năng anonymous: mượn gió kĩ năng
        
        anonymous: Không thông qua class trung gian dùng abstract class vừa
        đổ giá trị vừa vá luôn
        
        **Ưu điểm: Không cần class trung gian, làm thủ công, nhanh và gọn
        **Nhược điểm: Không có cái khuôn nên không nhân bản được
        
    */
        Shape xxx = new Shape("Bé Na", "Bảy màu") {// Hành động rót giá trị
            @Override
            public double getPerimeter() {// vừa vá. Nhưng không có ct để tính
                return 50;
            }
            
            @Override
            public double getArea() {
                return 15;
            }
            
            @Override
            public void paint() {
                String str = String.format("xxx: %s|%s|%.2f|%.2f",
                owner, color, getPerimeter(), getArea());
                System.out.println(str);
            }
        };//LƯU Ý NÓ CẦN DẤU ';' ở đây vì từ trên xuống dưới chỉ là một câu lệnh
        ds[4] = xxx;
        for (Shape item : ds) {
            item.paint();
        }
        //đặt tên cho nó là item. Nói nó mỗi item hãy paint ra đi
    }
    
}
