package runtime;

import data.StudentV1;
import data.StudentV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
2 object có thể so sánh bằng cách nào?
== : so sánh địa chỉ
- ta có .equalTo(): boolean và compareTo(): int
    chỉ vận hành với wrapper class và String
- nếu anh muốn so sánh hai sinh viên thì equalto() và compareTo() sẽ không đáp ứng được 
- bản chất so sánh object là:
        vì một đối tượng được mô tả rất nhiều props phức tạp nên không thể nhìn hoa loa
        rồi nói ai hơn ai được. Mình phải quy từ object phức tạp về thành so sánh
        String hoặc primitive
- sort: sắp xếp
        comparable: tính đố kỵ
        comparator: anh trọng tài
*/
public class Program {
    public static void main(String[] args) {
        //trong java không có hàm. Nhưng nếu muốn method sử dụng như hàm
        //thì ta thêm static vào method. Khi ta tạo 5 object thì chỉ xài chung
        //một cái hàm vì khi đó cái hàm đã thuộc về class rồi => xài chung
        //==> tiết kiệm vùng nhớ
        //sortV1();
        sortV2();
        
    }
    
    public static void sortV1(){
        //tạo ra cái mảng chứa dánh sách sinh viên
        ArrayList<StudentV1> stuList = new ArrayList<>();
        //thêm các sinh viên vào trong list
        stuList.add(new StudentV1("SE001", "Lê", "An", 6));
        stuList.add(new StudentV1("SE005", "Nguyễn", "Bình", 9.2));
        stuList.add(new StudentV1("SE002", "Lý", "Cường", 8.5));
        stuList.add(new StudentV1("SE004", "Trần", "Dũng", 7));
        stuList.add(new StudentV1("SE003", "Võ", "Em", 9.9));
        
        /*
        studentList: là cái mảng co giãn chứa rất nhiều StudentV1 là những đứa
        sinh viên không có tính đố kỵ. Tức là bọn chúng không có xu hương thích so sánh 
        lẫn nhau nên không thể tự sắp xếp
        
        lúc này em cần một anh trọng tài (Comparator) đứng ra giúp mình so sánh hai
        sinh viên bất kỳ. Vậy Comparator là gì?
        +về mặt hiểu: Comparator là một anh trọng tài đứng ở giữa 2 object và ảnh
        sẽ dựa vào yếu tố nào đó(màu tóc, nước da) để quyết định xem ai lớn hơn ai
        +về mặt lí thuyết: Comparator là một inteface có duy nhất một method duy nhất
        là compare(). Mình phải implement(bổ sung code) một tiêu chí mà mình muốn 
        so sánh. Nếu thỏa điều kiện thì return 1(lớn), không return -1(bé)
        
        sau khi anh tạo xong thì có thể bỏ danh sách vào để so sánh thông qua 
        Collections.sort
        */
        //tạo ra anh trọng tài có tên là 'ordById'
        //Nếu comparator có thêm <> nó sẽ bổ nghĩa. Nếu bỏ thêm Student vào 
        //nó sẽ hiểu so sánh Student. Khi đó sẽ flexible
        //bổ nghĩa rõ ràng sẽ dễ sử dụng
        Comparator ordById = new Comparator<StudentV1>() {
            @Override
            public int compare(StudentV1 t1, StudentV1 t2) {
                if(t1.getId().compareTo(t2.getId()) > 0){
                    return 1;//swap
                }else{
                    return -1;
                }
            }
        };
        //sau khi có anh trọng tài rồi thì mình sẽ nhét ảnh vào danh sách của mình
        //để ảnh so sánh các sinh viên cho mình từ đó dẫn đến "sắp xếp"
        //Collections là class chứa rất nhiều method phục vụ cho những đối tượng
        //thuộc Collection, Collection là tập hợp các loại mảng đặc biệt
        //trong đó có ArrayList
        Collections.sort(stuList, ordById);
        //sau khi sắp xếp rồi thì in ra
        for (StudentV1 item : stuList) {
            item.showInfor();
        }
    }
    
    public static void sortV2(){
        ArrayList<StudentV2> stuList = new ArrayList<>();
        stuList.add(new StudentV2("SE001", "Lê", "An", 6));
        stuList.add(new StudentV2("SE005", "Nguyễn", "Bình", 9.2));
        stuList.add(new StudentV2("SE002", "Lý", "Cường", 8.5));
        stuList.add(new StudentV2("SE004", "Trần", "Dũng", 7));
        stuList.add(new StudentV2("SE003", "Võ", "Em", 9.9));
        //stuList bây giờ toàn chứa StudentV2
        //là những thằng có sẵn trong mình tính ganh đua. Nên chúng k cần anh trọng
        //tài nữa và tự so sánh lẫn nhau
        Collections.sort(stuList);
        for (StudentV2 item : stuList) {
            item.showInfor();
        }
        
    }
    
    
}
