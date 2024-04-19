package data;

import java.util.Scanner;

public class Student extends Person {//muốn thừa hưởng mấy cái prop kia thì phải nhận cha 
    //các props riêng của Student
    private String id;
    private float gpa;
    private String email;
    //phểu có đối số

    //của người lớn như name, gender, yob phải đổi lên trên trước
    public Student(String name, String gender, int yob, String id, float gpa, String email) {
        super(name, gender, yob);//gọi cái phểu của cha
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
    
    //setter thông minh là setter sẽ yêu cầu người dùng truyền vào valid thì trả
    //ra true rồi set lại. Nếu không valid trả ra false không set

    public boolean setId(String id) {
        if(id.length() <= 0){
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        if(!id.matches("^[S][E]\\d{7}$")){
            System.err.println("Id phải có dạng SEDDDDDDD với D là số!!!");
            return false;
        }
        // nếu vượt qua các tầng if ở trên validate(xác thực)
        //thì mình sẽ gán giá trị vào object và return true
        this.id  = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("GPA không hợp lí");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public boolean setEmail(String email) {
        if(email.length() <= 0){
            System.err.println("Email được bỏ trống!!!");
            return false;
        }
        if(!email.contains("@")){
            System.err.println("Email không hợp lí!!!");
            return false;
        }
        if(!email.matches("^[a-z]*\\d{0,6}[@][a-z]*[.][a-z]*([.][a-z]*)*$")){
            System.err.println("Email không hợp lí!!!");
            return false;
        }
        this.email = email;
        return true;
    }
    //vì có phểu rổng nên ta có hàm inputInfor
    //hàm này độ lại từ hàm của thằng cha
    
    @Override
     public void inputInfor(){
        //thay vì copy y lại rồi ta phải qua kia mở proteceted cho các biến 
        //thì ta có thể kêu thằng cha ra trực tiếp để nhập những thông tin đó
        super.inputInfor();//cha ơi cha nhập giúp con đi
        Scanner sc = new Scanner(System.in);
        //nhập những thông tin riêng thằng con. Nhưng vì ta có setter đặc biệt
        //nên ta phải người dùng phải nhập valid luôn
        
        //nhập vào id:
        System.out.println("Nhập vào IdStudent: ");
        while(!setId(sc.nextLine()));
        //nếu ra được false ko valid thì ta để dấu ! biến mày thành true rồi
        //bắt mày nhập lại đến chết
        
        //nhập vào gpa;
        System.out.println("Nhập vào gpa: ");
        while(!setGpa(Float.parseFloat(sc.nextLine())));
        //ép kiểu để tránh buffer giữa chữ và số
        
        //nhập emali
        System.out.println("Nhập vào email: ");
        while(!setEmail(sc.nextLine()));
    }
    //showInfor. Lấy hàm cảu cha rồi ta độ lại
    @Override
    public void showInfor(){
        //kêu thằng cha ra in ra thông tin của nó khoit set protected
        super.showInfor();
        //độ lại của thằng con
        String str  = String.format("|%s|%.2f|%s|\n", id, gpa, email);
        //để  \n giúp sau khi in xong mới xuống hàng
        System.out.printf(str);//in trên một hàng
    }
     
    //hàm coi thử thằng nào gpa > 8 không. Ta phải xài hàm trả ra boolean để
    //hợp lí với if(boolean) bên program
    public boolean hasScholarship(){
        return this.gpa > 8;
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