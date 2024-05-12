package runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
Collection: là những cái mảng rất đặc biệt
Collections: một class chứa rất nhiều method hỗ trợ cho Collection
Mảng bình thường thì có bộ công cụ tên là Arrays
Collection được chia thành 4 dạng chính
+List(thứ tự giữ nguyên): giống như mảng bthg đưa vào như thế nào thì sẽ lưu trữ
y như vậy. List khác mảng bình thường ở chỗ là co dãng
+Queue:có cấu trúc như hàng đợi. Vào trước ra trước hoặc ra sau tùy theo set up đôi
khi không đúng thứ tự
+Set: tập hợp các phần tử không trùng lập nên đưa vào 7 7 4 9 chỉ còn 7 4 9. Không dược ổn định

*library: những cái hàm đã được xây dựng sẵn, mình gọi ra rồi sử dụng thôi. Vd: sqrt()
*framework: một đống code ta có thể bổ sung code vào thêm để hoàn chỉnh

**Collection là framework
*/
public class Program {
    public static void main(String[] args) {
        playWithArrayList();
        
    }
    public static void playWithArrayList(){//build
    /*
        ArrayList là một cái mảng đặc biệt và là class triển khai(implement) của 
        interface List
        ArrayList rất giống array primitive(mảng cùi bên C). Nhưng array primitive
        không co dãng được(xin bao nhiêu thì xài bấy nhiêu) còn ArrayList thì là mảng
        động(co giãn)
    */
    //tạo thử mảng cùi
    int arrPrimitive[] = new int[10];//xác định rõ số lượng. Thiếu 10 là bug ngay
    //tạo ra mảng cùi có 10 phần tử mà thôi, không nhét thêm vô được mà xài ít hơn 
    //cũng không được 
    //arrPrimitive sẽ lưu được gì? primitive datatype
    //                             Object datatype      ==>Tùy theo cách tạo mà sẽ lưu như nào
    //                             Wrapper class|String
    
    //Tạo thử mảng bằng ArrayList
    //ArrayList: lại là 1 mảng có khả năng co giản nhưng chỉ chơi được với Object
        ArrayList<Integer> arrIntList = new ArrayList<>();
        //Lưu nhưng Wrapper Integer
        //Lưu ý: nó không thể <int> được chỉ bỏ Wrapper vì mảng này chỉ chơi với Object
        
        //các Collection(bao gồm ArrayList) thì không chơi với primitive datatype
        //nên phải dùng Wrapper Class tương ứng
        
        //**Lưu ý: Vì List là một inteface còn ArrayList đã implement rồi. Thì nếu 
        //ta khai báo List-new List thì ta phải vá nó như anonymous
        List<Integer> arrIntListV2 = new ArrayList<>();
        //Khai cha--new con
        
        //các method của ArrayList
        //.add(value): thêm mới một value vào trong list
        arrIntList.add(new Integer(3));//vì mình lưu là Object nên phải new mới
        arrIntList.add(new Integer(2));
        arrIntList.add(4);//lưu được nhờ cơ chế auto unboxing
        
        System.out.println(arrIntList);//[3 2 4]//arrIntList.toString()
        
        //.clear(): xóa hết các phần tử trong mảng
        arrIntList.clear();//xóa sạch
        System.out.println(arrIntList);//mảng rỗng []
        
        //.add(index, value): 'nhét' value vào vị trí index
        arrIntList.add(0, 3);//[3]
        arrIntList.add(1, 5);//[3 5]
        arrIntList.add(2, 4);//[3 5 4]
        arrIntList.add(1, 4);//[3 4 5 4]
        
        System.out.println(arrIntList);
        
        //thêm giá trị vào cho arrIntListV2
        arrIntListV2.add(9);
        arrIntListV2.add(12);
        //.addAll(index, list) thêm list vào index
        arrIntList.addAll(2, arrIntListV2);//nhét [9 12] vào đúng vị trí số 2
        //arrIntList
        System.out.println(arrIntList);//[3 4 9 12 5 4]
        
        //giả xử, anh cần truy xuất mảng cùi, rồi sau đó muốn quay lại xài ArrayList
        //để co giản thì phải làm sao
        Integer arrDemo[] = {3,5,7};
        //giờ chuyển từ mảng cùi xang mảng xịn co giản
        //Arrays: là class chứa các method hỗ trợ cho array
        //Arrays.asList(ds): biến array thành List
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arrDemo));
        //arrList là phiên bản ArrayList của arrDemo
        //arrList sẽ co giản được nhưng truy xuất chậm
        
        //.toArray(): biến từ List về lại arrayPrimitive
        //biến từ List về lại arrayPrimitive
        Integer numList[] = new Integer[arrList.size()];//tạo cái mảng nguyên thủy 
        //với size của mảng xịn vì để tạo arrayPrimitive nó cần kích thước lúc đầu khởi tạo
        //lúc khởi tạo
        //2. nạp giá trị từ mảng xịn vào mảng arrayPrimitive
        arrList.toArray(numList);
        //3. xem kết quả thu được
        System.out.println(numList);//mảng cùi thì .toString chưa được Override
        //để hiển thị thì ta cần duyệt vòng for(0 --> size - 1)
        //.get(index) để lấy ra xem pt ở vị trí index trong list
        //arrList[3 5 7]
        System.out.println(arrList.get(1));//được 5 vì nó nằm ở vị trí số 1
        
        //.set(index, vakue): gán | thay thế giá trị ở vị trí index bằng value
        //muốn đổi số 5 thành số 9 
        arrList.set(1, 9);//đổi 5 thành 9 
        //arrList[3 9 7]
        System.out.println(arrList);
        
        //thử thách: swap 3 và 7 trong mảng đi, chỉ dùng get và set
        Integer tmp = arrList.get(0);//cho tmp = giá trị đầu tiên 3
        arrList.set(0, arrList.get(2));//thay số ở vị trí số 0 vào vị trí số 2
        arrList.set(2, tmp);//thay vị trí số 2 bằng tmp(giá trị 3)
        //vậy arrList sẽ là [7 9 3]
        
        //iterable(interface): tính khả lập(khả duyệt)
        //iterator: là một object có khả năng định nghĩa được trình tự và giá trị
        //cho lần gọi tiếp theo
        //đưa cho em 1 pt, tính toán và chuẩn bị cho pt tiếp theo
        
        //mô tả những gì diễn ra trong fore
        //khi mình muốn fore thằng arrList, anh sẽ tạo ra iterator từ arrList
        Iterator<Integer> it = arrList.iterator();//anh kêu arrList cung cấp
        //it là iterator của arrList và fore sẽ dùng it để duyệt thay vì dùng
        //for từ 0 đến size - 1
        System.out.println(it.hasNext());//còn thì true, hết false
        System.out.println(it.next());//lấy ra phần tử tiếp theo 7
        System.out.println(it.next());//lấy ra phần tử tiếp theo 9
        System.out.println(it.next());//lấy ra phần tử tiếp theo 3
        //System.out.println(it.next()");//lấy hết rồi nên lỗi
        //**Lưu ý sau khi lấy thì sẽ tới tiếp thằng tiếp theo
        
        //.remove(index): xóa phần tử nằm ở vị trí index trong list
        //arrList[7 9 3]
        arrList.remove(1);//xóa 9 vì 9 nằm ở vị trí số 1
        //arrList[7 3]
        System.out.println(arrList);
        //removeAll(list): xóa hết các phần tử trong list
        
        arrList.add(5);
        arrList.add(9);
        arrList.add(2);
        arrList.add(12);
        //arrList[7 3 5 9 2 12]
        //arrIntListV2[9, 12]
        arrList.removeAll(arrIntListV2);
        //trong arrList xóa hết các phần tử thuộc arrIntListV2|xóa 9 và 12
        System.out.println(arrList);//[7 3 5 2]
        
        //.size(): lấy kích thước
        //.clone(): tạo ra một list mới có cùng pt, kích thước, dung lượng
        ArrayList<Integer> demoClone = (ArrayList) arrList.clone();//ép kiểu
        
        //clone là shallow copy: chưa cắt được hết dây mơ rễ má
        //deep copy:
        
        //.contain(key): tìm key trong danh sách(boolean)
        //.notifyCapacity(): thông tin giới hạn lưu trữ
        
        //.isEmpty(): có trống hay không(boolean)
        //.indexOf(key): tìm key ở vị trí nào
        //.trimToSize(): thu nhỏ đến kích thước thật
        
    }
}
