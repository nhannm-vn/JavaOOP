package runtime;
//+List(thứ tự giữ nguyên): giống như mảng bình thường đưa vào như nào sẽ lưu trữ
//y như vậy. List khác mảng bthg ở chỗ là co dãng

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        playWithArrayList();
    }
    public static void playWithArrayList(){
        /*
        ArrayList là một cái mảng đặc biệt và là class triển khai(implement) của
        interface List
        ArrayList rất giống array primitive(mảng cùi bên C). Nhưng array primitive
        không co dãng được(xin bao nhiêu thì xài bấy nhiêu( còn ArrayList thì là 
        mảng động và co dãng được)
        */
        
        //thử khai báo mảng cùi
        
        int arrPrimitive[] = new int[10];//mảng cùi thì phải xác định rõ số lượng
        //chỉ được xài bấy nhiêu khai báo. Mảng có thể chứa primitive có thể chứa 
        //object cũng được phụ thuộc cách khai báo
        //các mảng còn lại chỉ có thể lưu object thôi
        
        //tạo thử mảng bằng ArrayList
        ArrayList<Integer> arrIntList = new ArrayList<>();
        //Lưu ý: nó không thể <int> được chỉ bỏ Wrapper vì mảng này chỉ chơi với Object
        
        //Khai báo theo kiêu khác
        List<Integer> arrIntListV2 = new ArrayList<>();
        //khai cha new-con
        //không thể khai List-new List được vì List là một interface. Nếu ta làm
        //như vậy tạo mới thành ra là kỹ thuật anonymous ta phải đi vá lỗ
        //biết bao nhiêu lỗ mà vá cho hết
        
        //các method của ArrayList
        //.add(value): thêm mới một value vào trong list
        
        arrIntList.add(new Integer(3));//vì mình lưu là Object nên phải new mới
        arrIntList.add(2);
        arrIntList.add(4);//lưu được vì nhờ có cơ chế auto unboxing
        
        System.out.println(arrIntList);//[3 2 4]
        
        //.clear(): xóa hết tất cả các phần tử trong mảng
        arrIntList.clear();
        System.out.println(arrIntList);//mảng rỗng
        
        //.add(index, value): 'nhét' value vào vị trí index
        arrIntList.add(0, 3);//[3]
        arrIntList.add(1, 5);//[3 5]
        arrIntList.add(2, 4);//[3 5 4]
        arrIntList.add(1, 4);//[3 4 5 4]
        //mảng này là mảng co giãn nên mình nhét vào nó sẽ tự động giãn ra
        
        //thêm giá trị vào cho arrIntListV2
        arrIntListV2.add(9);
        arrIntListV2.add(12);
        
        //.addAll(index, list) thêm list vào index
        arrIntList.addAll(2, arrIntListV2);
        //nhét [9 12] vào đúng vị trí số 2
        //arrIntList
        System.out.println(arrIntList);//[3 4 9 12 5 4]
        
        //giá sử anh cần truy xuất mảng cùi sau đó muốn qua lại xài ArrayList thì sao
        
        Integer arrDemo[] = {3,5,7};
        
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arrDemo));
        //arrList là phiên bản ArrayList của arrDemo
        //arrList sẽ co giản được nhưng truy xuất chậm
        
        //biến mảng xịn về mảng cùi
        Integer numList[] = new Integer[arrList.size()];
        
        arrList.toArray(numList);
        
    }
}
