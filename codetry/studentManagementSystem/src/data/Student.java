package data;

import java.util.Scanner;

public class Student extends Person{//nhận cha để đc thừa hưởng và có thể mở rộng
    //props chỉ có riêng nó mới có
    private String id;
    private float gpa;
    private String email;
    
    //constructor có đối số
    //thuộc tính chung và của cha để lên đầu trước
    //bất cứ cái gì cùng tên nhưng khác parameter gọi là overrload
    public Student(String name, String gender, int yob, 
            String id, float gpa, String email) {
        super(name, gender, yob);//hành động gọi cha
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    
    //phểu không có đối số

    public Student() {
        
    }
    
    //getter

    public String getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public String getEmail() {
        return email;
    }
    
    //setter thông minh
    //setter(thông minh): thay vì nhận đc giá trị rồi bỏ vào luôn thì mình sẽ 
    //kiểm tra. Nếu value nếu valid thì mình gán giá trị và return true
    //còn nếu value not valid thì mình chửi và return false

    public boolean setId(String id) {
        //lỗi để trống
        if(id.length() <= 0){
            //đổi out thành err cho ra đc màu đỏ
            System.err.println("Không được để trống!!!");
            return false;
        }
        if(!id.matches("^SE\\d{7}$")){//dấu ! nếu id không khớp với đoạn này
            System.err.println("Id phải có dạng SEDDDDDDD với D là số");
            return false;
        }
         // nếu vượt qua các tầng if ở trên validate(xác thực)
        //thì mình sẽ gán giá trị vào object và return true
        this.id = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("GPA không hợp lệ!!!");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public boolean setEmail(String email) {
        if(email.length() == 0){
            System.err.println("Email không được bỏ trống!!!");
            return false;
        }
        if(!email.contains("@")){//nếu trong email không có dấu @
            System.err.println("Email không hợp lệ!!!");
            return false;
        }
        this.email = email;
        return true;
    }
    
    //hàm giúp thu thập thông tin từ người dùng
    //mình copy qua rồi độ lại Override
    //nếu người gà thì bthg họ sẽ qua kia đổi private thành protected 
    //nhưng mình pro nên mình kêu thằng cha(super) ra làm cho mình và khỏi đổi 
    @Override
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        super.inputInfor();//gọi thằng cha ra làm
        //thay vì phải protected bên kia thì phải xài mẹo này
        //kêu cha ơi nhập cho con
        
        //nhập id
        System.out.println("Nhập StudentID: ");
        //kiểm tra nhờ vào hàm set xong mới cho nó gán giá trị
        /*
        while(true){
            String inpId = sc.nextLine();
            boolean isValid = setId(inpId);//nhập cái id từ bàn phím nếu ok thì cho gán
            if(isValid) break;//nếu như nó valid trả ra true thì thôi k thì lặp lại
        }*/
        while(!setId(sc.nextLine()));
        //nếu nhập vô mà valid thì nhờ dấu ! trả ra false ==> while sẽ dừng
        
        //gpa
        System.out.println("Nhập vào GPA: ");
        /*
        while(true){
            int inGpa = sc.nextInt();
            boolean isValid = setGpa(inGpa);
            if(isValid) break;
        }
        */
        //nếu nhập vô mà valid thì nhờ dấu ! trả ra false ==> while sẽ dừng
        while(!setGpa(Float.parseFloat(sc.nextLine())));
 //vì nhập liên tục giũa chữ và số sẽ bị buffer, nên ta cần ép kiểu parse
 //để giúp cho tất cả chuỗi đều trở về dạng float bao gồm (\n)
        
       //email
       /*
       while(true){
           String inpMail = sc.nextLine();
           boolean isValid = setEmail(inpMail);
           if(isValid) break;
       }*/
        System.out.println("Nhập vào email: ");
       while(!setEmail(sc.nextLine()));
       //nếu nhập valid thì hàm set sẽ trả ra true mà ! nên thành false ==> while dừng
       
    }
    //showInFor: copy cha nó và độ lại
    //nếu qua kia đổi props thành protected thì quá gà nên mình kêu
    //trực tiếp thằng cha làm luôn
    
    @Override
    public void showInfor(){
        super.showInfor();
        //cha ơi cha viết mấy cái mà cha có đi
        
        //tới phần riêng của mình
        //in xong ba cái của cha rồi tới con rồi mới xuống hàng
        String str = String.format("|%s|%f|%s\n", id, gpa, email);
        System.out.printf(str);
//nhưng nếu in như vậy thì nó sẽ bị trên dưới cho nên phải chỉnh lại ==> printf

    
    }
    //hàm coi thử thằng nào có học bổng kết hợp với if bên kia
    public boolean hasScholarship(){
        return this.gpa > 8;//nếu lớn hơn 8 thì trả ra true
    }
    
}
/*
Student class
    sử dụng kế thừa để có name, gender, yob, của Person
    riêng Student thì muốn có thêm id, gpa, email
    phểu có đối số và k có đối số
    getter và có setter nhưng thông minh
    showInFor
*/