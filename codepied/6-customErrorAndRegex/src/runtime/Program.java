package runtime;

import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        //REGEX
        //Regex | regular expression | Pattern | Biểu thức chính quy
        
        String str = "SE1234567";
        String regex = "^[Ss][Ee]\\d{7}";
        checkString(str, regex);
        //Học viết:
        //1.regex chỉ kiểm tra có phân biệt hoa thường
        checkString("name", "nAme");
        //2.có thể bật chế độ không quan tâm hoa thường
        checkString("nAme", "(?i)name");//true
        //3.1 kí tự bất kỳ có dấu: . thay mọt thứ trừ enter
        checkString("mey", "m.y");//true
        //mey|may|m,y|m+y true
        //my|maay| false
        //4.lập lại ký tự trước đó từ 0 đến nhiều lần: "*"
        //^m*y$ khởi đầu là chữ m kết thúc là chữ y
        //y|my|mmy|mmmmmy|mmmmmmmmy   true
        //m|mey|myy false
        //5.group: ()
        checkString("mery", "m(er)*y");
        //merererererery|my|mery true
        //mey|mry|mmy|myy false
        //^m[^aer]y$
        //6. phần tử bất kỳ trong set[...]
        //m[aer]y : may|mey|mry: true
        //m[^aer]y: may|mey|mry: false còn lại true hết
        
        //7.tập hợp chữ
        //[a-z]: bên trong miễn cần có chữ thường là đc
        //[A-Z]: bên trong chữ hoa
        //[A-Za-z]: bên trong là ký tự chữ thường hoặc hoa
        
        //8. tập hợp số
        //[0-9]: một ký tự từ 0 đến 9
        
        //9. giới hạ ký tự: {}
        //{3}: lập lại 3 lần
        //{2,}: lập lại từ 2 lần trở lên
        //{2,4}: lập lại từ 2 đến 4 lần
        //{0,}: * lặp bao nhiêu cũng đc
        //{1,}: +
        //{0,1}: có hoặc không đều ok
        
        //10. hoặc | kết hợp ()
        //^toi (bi|ko|rat) gay$
        
        //^([A-Z][a-z]*)( [A-Z][a-z]*)*$: nhập đúng tên
        
        //11.shorthend: viết tắt
        //1. \w: [a-zA-Z_0-9] \W: phủ định
        //2. \d: [0-9] \D: phủ định
        //3. \s: space \S: phủ định
        //Tryhard:
        //Regex về tiền tệ: 100 000 000
        //Regex về email
        //Regex về mã số sv
        //Regex về tìm khoảng cách thừa
        
        
        
        //-----------------------------
        //Try catch
        //error compilation: lỗi trong quá trình biên dịch code
        //bug do synax sai do viết code sai nó bào liền
        //error runtime: lỗi trong quá trình người dùng sử dụng
        //lỗi do k nhập đúng nhập tào lao sai
        
        //Scanner: đảm nhiệm trách nhiệm cho các hàm nhập giá trị
        Scanner sc = new Scanner(System.in);//muốn nhập giá trị từ bàn phím
        int age;
        
       
        //khi thằng người dùng nhập láo mình sẽ tạo cái tường chặn cái lỗi
        //rồi hứng nó
        try{//bọc cái rào lại
            System.out.println("Nhập tuổi đi: ");
            age = sc.nextInt();
            if(age < 10 || age >= 30){//nếu m nhập cho t vậy hệ thống k báo lỗi
            //nhưng tao coi đó như lỗi để ném
                throw new Exception();//tự tạo ném cái lỗi
            }
        }catch(Exception e){//báo nó là ngoại lệ rồi ném chữ ngu ra 
            System.out.println("ngu");
            //System.out.println(e);
        }
        //nếu đoạn code bên trong bị lỗi thì sẽ in ra chữ ngu
        System.out.println("Ahihi làm tốt lắm");
        
    }
    public static void checkString(String str, String regex){
        System.out.println(str.matches(regex));
    }
}
