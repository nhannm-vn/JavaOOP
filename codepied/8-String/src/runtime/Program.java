package runtime;

import java.util.StringTokenizer;

public class Program {
    public static void main(String[] args) {
        /*
            bên C tạo chuỗi bằng cách tạo mảng. Bên java k coi chuỗi là mảng mà 
        coi chuỗi là một object
        */
        String lastName = new String("Điệp");
        String tmp = lastName;//tmp tham chiếu lastName
        //lastName trong stack trỏ vào object trong heap
        //tmp nằm trong stack, lastName là con trỏ đưa giá trị cho con trỏ tmp
        //dẫn đến con trỏ tmp cùng trỏ vào vùng object bên heap dẫn đến( 2 chàng
        //trỏ vào 1 nàng)
        String firstName = "Lê";
        /*
            Cơ chế này gọi là pool. Khi không dùng new là cơ chế pool. Nghĩa là
        bên trong heap luôn có vùng nhớ dành cho String và tên là pool. Mặc định
        khi khai báo chuỗi mà không dùng new thì nó sẽ nằm bên trong vùng pool 
        luôn 
        */
        /*
            **Trong java String là một object immutable
        +immutable là một object bất biến, không tác động và chỉnh sửa được
        +các thao tác lên immutable thường trả về một object kết quả
        +lastName.concat(firstName); không thay đổi mà là tạo ra một chuỗi mới
        ko đc ai trỏ tới nên bị mất
        */
        
        //muốn nối Lê Điệp chỉ cần :
        //lastName.concat(firstName); dẫn tới khi lastName nối firstName
        //thì thành Điệp Lê dẫn tới tmp bị ảnh hưởng ==> SAI
        
        //tại sao in ra vẫn chỉ là chữ Điệp?
        /*
        ==> vì bọn này đều là string immutable nên không tác động lên nó được
        dẫn tới hành động lastName.concat(firstName) không làm thay đổi chuỗi
        mà tạo ra object chuỗi mới Điệp Lê
        **Mà vì không ai hứng kết quả nên bị mất
        */
        lastName = lastName.concat(firstName);
        System.out.println("lastName nè: " + lastName);
        System.out.println("tmp nè: " + tmp);
        /*
            Không chỉnh sửa gì hết mà tạo ra String mới Điệp Lê sau đó cho thằng
        lastName trỏ vào vùng mới nên lập tức sợi dây trỏ lúc đầu bị cắt rồi
        trỏ qua object mới. Nên khi chạy code lastName có được Điệp Lê còn tmp
        vẫn là chữ Điệp
        */
        /*
            Câu chuyện 2 chàng trỏ 1 nàng. Anh lastName có làm gì đó với cô này
        nhưng cô này là String immutable ko thay đổi được nên anh tmp không phải
        đổ vỏ. Và dẫn tới ảnh tạo ra cô mới và đi theo cô mới
        ==> làm gì cũng không được hết chỉ có tạo ra thằng mới và đi theo
        
        */
        
        //StringBuffer và StringBuilder
        //Hai thằng này cũng là String nhưng lại là mutable
        //hai thằng này có thể chỉnh được, mọi thao tác đều ảnh hưởng
        //object có thể đc chỉnh sửa sau khi đã đc tạo
        
        StringBuilder lastName2 = new StringBuilder("Điệp");
        StringBuilder tmp2 = lastName2;
        StringBuilder firstName2 = new StringBuilder("Lê");
        //Vẫn tạo ra hiệu ứng 2 chàng trỏ 1 nàng. Chỉ khác dùng StringBuilder
        
        lastName2.append(firstName2);
        System.out.println("lastName2: " + lastName2);
        System.out.println("tmp2: " + tmp2);
        //bởi vì nó là mutable nên chui vào chỉnh thẳng luôn
        //nên là anh này thay đổi thì anh kia cũng thay đổi luôn
        
        //StringTokenizer: split
        String information = "SE123|Điệp Đẹp Trai|2004|9.9";
        StringTokenizer st = new StringTokenizer(information, "|");
        System.out.println(st.countTokens());//đém xem cắt đc bao nhiêu khúc
        System.out.println(st.hasMoreTokens());//true vì chưa băm còn nguyên
        
        while(st.hasMoreTokens()){//khi vẫn còn token là còn băm là in ra, ko còn token thì k băm nữa
            System.out.println(st.nextToken());//hàm băm xòng và in ra các phần tử
        }
        
        System.out.println(st.countTokens());//lúc này sau khi băm thì 0 còn token
        System.out.println(st.hasMoreTokens());//false vì k còn nữa
        System.out.println(information);//không bị mất do là immutable
        
        //playWithStringMethod();
        playStringComparision();
        
    /*
        +Program dùng để chứa main chứ k tạo object. Dùng để lưu trữ cái hàm và
        không có nhu cầu tạo ra nhiều object 
        +Những thằng nào được viết cùng bậc với main đều phải static hết. Thằng
        Program ko dùng để đúc mà là để chứa thôi
        +Viết chung xài tại class nên không cần . gì hết
    */    
    }
    public static void playWithStringMethod(){
        //khi em dùng string, em phải luôn nhớ String là object immutable
        //mọi thao tác của em đều k ảnh hưởng String, các method
        //thường có xu hướng trả ra object kết quả, nên lúc xài method 
        //phải để ý xem nó trả ra cái gì
        String str1 = "Điệp";
        String str2 = "Đẹp Trai";
        //str1.concat(str2); hành động này k làm thay đổi String mà tạo ra chuỗi 
        //mới k ai hứng ==> vô nghĩa
        str1 = str1.concat(str2).concat("Quá").toUpperCase();
        //nếu trả ra object có thể chấm hoài, nhưng trả ra primitive thì k chấm đc nữa
        System.out.println(str1);
        
        str1 = "Điệp Đẹp Trai";
        str2 = "Đẹp";
        //tìm chuỗi trong chuỗi
        System.out.println(str1.indexOf(str2));//trả ra vị trí đầu tiên 5
        //tìm kí tự tại vị trí có sẵn
        System.out.println(str1.charAt(9));//tìm vị trí kí tự tại 9 ra T
        //kiểm tra xem có tồn tại hay không
        System.out.println(str1.contains(str2));//true
        
        
    }
    
    public static void playStringComparision(){
        String s0 = new String("BÉ HỨA HỌC HÀNH CHĂM NGOAN");
        String s1 = "BÉ HỨA HỌC HÀNH CHĂM NGOAN";//pool
        String s2 = "BÉ HỨA HỌC HÀNH CHĂM NGOAN";//pool
        String s3 = "bé hứa học hành chăm ngoan";//pool
        String s4 = new String("BÉ HỨA HỌC HÀNH CHĂM NGOAN");
        String s5 = new String("BÉ HỨA HỌC HÀNH CHĂM NGOAN");
        /*
           Vùng nhớ có 2 vùng là Stack và Heap mà trong Heap có vùng nữa là pool
        +Những thằng mà dùng new là tạo ra vùng nhớ mới nằm các vị trí khác nhau
        +Nhưng nếu tạo pool vd: s1 nằm trong stack và trỏ tới pool. Nhưng tới s2
        được tạo pool có dòng chữ giống nhau quá và nằm chung một hồ(pool)
        nên trỏ chung một chỗ. Nếu vậy thì thằng này làm thằng kia bị ảnh hưởng
        rồi sao??? Nhưng không sao mình là immutable nên anh này làm gì đó thì 
        cô kia không thay đổi mà tạo ra chuỗi mới
        
          Khi dùng pool tiết kiệm được vùng nhớ cho nhưng thằng có cùng giá trị
        với nhau và xài chung vùng nhớ. Nhưng mình sợ (2 chàng trỏ một nàng) nhưng
        không sao mình có immutable nên anh này làm anh kia không thay đổi mà tạo
        ra vùng nhớ mới. NÊN ANH NÀY LÀM ANH KIA KHÔNG THAY ĐỔI
        
        */
        //pool nếu tụi mình giống nhau như vậy thì trỏ cùng 1 khu đi
        //nhưng pool + immutable nên thằng này làm k ảnh hưởng thằng kia
        
        //chuỗi đéo so sánh dấu bằng. So như vậy là sao địa chỉ
        System.out.println(s0 == s1);//thằng trong pool thằng ngoài ==> false
        System.out.println(s1 == s2);//2 thằng nằm cùng pool mà cùng giá trị 
        //2 chàng trỏ một nàng ==> true
        System.out.println(s2 == s3);//Tuy cùng pool nhưng thằng hoa thường ==> false
        System.out.println(s3 == s4);//Khác vùng false
        System.out.println(s4 == s5);//2 cái new mới khác ==> false
        
        //chuỗi mà so sánh == là so địa chỉ
        //muốn so giá trị thì
        System.out.println(s0.equals(s1));//ko nhìn địa chỉ mà nhìn giá trị ==> true
        System.out.println(s3.equalsIgnoreCase(s5));//bỏ qua thường hoa
        System.out.println(s1.compareTo(s2));// ra số 0
    }
}
