package runtime;

import data.Star;


public class Program {
    public static void main(String[] args) {
        Star mtp = new Star("Thanh Tùng", 1994, "nam", "cơn mưa ngang qua");
        mtp.showInFor();
        Star chiPuC = new Star("Huyền Chi", 1993, "nữ", "chiếc ố");
        chiPuC.showInFor();
        
        //mtp và chiPuC là object được tạo từ khuôn star nên cùng method
        
        /*
        new Star là hành động gọi cái phễu. Đưa giá trị vào phễu sẽ rót tương 
        ứng
        */
        
        //lấy giá trị của năm sinh sơn tùng: get
        System.out.println("Tùng sinh năm: " + mtp.yob);
        //vì public nên có thể set lại giá trị
        mtp.yob = 1999;//set lại giá trị của yob
        System.out.println("Tùng sinh năm " + mtp.yob);
        
        System.out.println("Tên của Tùng ne: " + mtp.getName());
        //set lại name bằng hàm set
        mtp.setName("Tùng yêu Điệp", 5071994);
        System.out.println("Tên của Tùng nè: " + mtp.getName());
        
        //câu chuyện tắm hồ bơi:
        Star ngocTrinh = new Star("Ngọc Trinh", 1984, "nữ", "eo 56");
       
        Star diepLe = new Star("10 Điệp", 1999, "nam", "thích gõ code");
        
        //Trường hợp này khi bên program gender để có static thì thuộc tính này
        //khi truyền mới sẽ bị giữ nguyên dẫn tới khi showInFor thì bị chung
        //giới tính từ khuôn class
        diepLe.showInFor();
        ngocTrinh.showInFor();
    }
}
/*
[starList]
*Modifier: bổ nghĩa
1.Access Modifier
2.Non-access Modifier

1.Access Modifier:
+default: phạm vi truy cập chung cùng package(chung hộp), bên ngoài package 
không thể thấy được. Trong cùng package có nhìn và sử dụng được nhau
+public: nghĩa là phạm vi truy cập lớn nhất, ai cũng có thể nhìn thấy và ai 
cũng có thể sử dụng được
+private: nghĩa là riêng tư. Mình nó thấy nó, không ai có thể nhìn thấy nó và 
truy cập được
vd: pks runtime
        class Program
    pks data
        public class Student
        private class Car
        class Bike
Program: thấy: Student          |ai thấy nó: 0
Student: thấy: bike             |ai thấy nó: tất cả
Car    : thấy: student và bike  |ai thấy nó 0
Bike   : thấy: student          |ai thấy nó: student, car

+protected là public nhưng chỉ public nhưng chỉ public với những thằng class con
mới được sử dụng(kế thừa, thừa hưởng những gì người đi trước đã làm và mở rộng)
(extends)

vd:
class Lâm{
    protected people Bà_Nội;
}
class Tuấn extends Lâm{
    protected int money = 1000;
}
class Hùng extends Tuấn{
    private people Người_Yêu;
}
//Tuấn  là cha của Hùng
//Lâm là bố của Tuấn, là ông nội của Hùng

*Quy tắc bất hiếu: cha cho con hết những gì cha có. Nhưng con thì không cho cha 
cái gì hết
*Class có thể nhận class khác làm cha hoặc con. Có thể nhận nhiều con nhưng chỉ 
được nhận 1 cha

//Tìm hiểu về class(quy tắc gôm tụ):
_Một class có hai thành phần: poperties(thuộc tính) và method(hành động)
+Trong Java vạn vật và hành động đều có người người chịu trách nhiệm
+Hàm viết bên ngoài không nằm trong bất cứ cái gì gọi là function. Khi xài gọi 
đến là xài
+Method được viết bên trong khuôn(class) nên khi xài phải chấm đến thằng chịu
trách nhiệm vd: Star.dance

_Muốn quản lí nhiều đối tượng hay(object) thì ta phải đưa(nhét) tất cả chúng vào
một cái mảng. Mảng chỉ chơi với những thằng cùng kiểu nên ta phải đặt 2 object
bất kỳ lên bàn cân rồi tìm điểm chung(poperties|method) và gôm điểm chung lại
tạo thành cái khuôn class. Từ đó nói rằng cái khuôn này là nguồn gốc của các 
object nói trên. Các chúng bây đều được tạo ra từ cái khuôn này ==> cùng loại
==> bỏ vào mảng được ==> quản lí được

2.Non-access Modifier
_final: áp dụng cho class, prop và method

**final nằm trong class:

+class vẫn tạo ra object nhưng không nhận class khác làm con. NHƯNG VẪN CÓ THỂ
NHẬN CLASS KHÁC LÀM CHA.
*class có cơ chế:
+class có thể nhận một class khác làm con(sinh học)
+ class có thể bỏ nguyên liệu vào và đúc ra object(công việc)
*Nếu như class có chữ final thì class vẫn tạo ra object nhưng không cho
class khác nhận mình làm cha

**final nằm trong properties:
+Bản chất của properties chỉ là các biến để lưu giá trị thôi. 
vd: final int yob = 1999;
==> final sẽ làm cho properties không thay đổi và trở thành hằng số

**final nằm trong method(hành động):
Vẫn cho kế thừa nhưng không Override(độ, chế) được

//Câu chuyện bán trà sữa
class Cha{
    protected "final" method: nấu_trà_sữa(){
        sữa, đường, than tre
    }
}

class Con extends Cha{
    //trạng thái class con độ thêm gọi là vượt mặt @Override
    method: nấu_trà_sữa(){
        sữa, đường hóa học, ma tóe
    }
}

**Cha có hàm nấu trà sữa rất ngon, con kế thừa cha ==> cũng có hàm nấu trà sữa
rất ngon. Nhưng với cách nấu đó không phù hợp với thời đại của con ==> nên 
thằng con độ chế lại cách nấu nên tuy đều là nấu trà sữa nhưng con nấu khác và
cha nấu khác ==> @Override(vượt mặt)

**Quy tắc bất hiếu thằng con chế ra nhưng thằng cha không được hưởng. Nên ổng
tức ổng đặt "final" vô công thức method ==> vẫn cho kế thừa cách nấu trà sữa. 
Nhưng nó là công thức cuối cùng ==> thằng con chỉ được thừa hưởng và không được
độ chế

**static: tĩnh lặng | đứng yên | không dịch chuyển được
Áp dụng cho properties và method
_Thay vì phân bản cho từng thằng thì mình không cho ai hết. Mình biến nó thành 
xài chung
_Nó không thuộc sở hữu của từng đối tượng object mà nó thuộc của chung(class)
vd: trên hàm main có static không tách ra. Tất cả đều xài chung main
==> static tức là không có nhân bản cho từng object. Không thuộc sở hữu của 
từng object mà thuộc sở hữu của khuôn(class), object nào cũng phải xài chung.

**abstract(trừu tượng):
abstract class Cha{
    abstract method: ăn trứng();
    abstract method: thành công();
    abstract method: yêu();
}
*Mỗi người định nghĩa thành công khác nhau
*Nếu kế thừa sẽ bị dính áp đặt. Cha định nghĩa sao con phải theo vậy. Vì vậy 
viết mà không ghi ra cụ thể
*Vì không định nghĩa được sẽ trở thành trù tượng
==> Một class chứa những hành động không giải thích được thì đây không phải 
class bình thường mà là abstract
*Một class mà có abstract method thì chắc chắn là abstract class. Nhưng một 
abstract class không nhất thiết phải có abstract method



*/

