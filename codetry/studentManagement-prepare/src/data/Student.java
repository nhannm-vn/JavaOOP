package data;
//student sẽ kế thừa để có những thuộc tính và method của cha nó

import java.util.Scanner;

public class Student extends Person{
    //các thuộc tính riêng của nó
    private String id;
    private double gpa;
    private String email;
    
    //constructor
    //phểu không có đối số

    public Student() {
    }
    //phểu có đầy đủ nhưng đẩy các thuộc tính của cha nó lên trước

    public Student(String name, String gender, int yob, String id, double gpa, String email) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    //getter

    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public String getEmail() {
        return email;
    }
    
    //setter thông minh có nghĩa là thông tin hợp lí thì mới set giá trị

    public boolean setId(String id) {
        //kiểm tra coi id hợp lí không nếu không thì trả ra false nếu hợp lí 
        //thì trả ra true nó giúp mình bắt buộc người dùng nhập đúng
        //*Không được bỏ trống
        if(id.isEmpty()){
            System.err.println("Không được bỏ trống id!!!");
            return false;
        }
        //*Không phù hợp, xài regex
        if(!id.matches("^[S][E]\\d{6}$")){
            System.err.println("Định dạng của id phải là SEDDDDDD với D là số!!!");
            return false;
        }
        //nếu vượt qua hết thì sẽ gán cho nó giá trị
        this.id = id;
        return true;
    }

    public boolean setGpa(double gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("gpa không phù hợp!");
            return false;
        }
        //nếu gpa hợp lí thì trả ra true và gán
        this.gpa = gpa;
        return true;
    }

    public boolean setEmail(String email) {
        if(email.isEmpty()){
            System.err.println("Không được bỏ trống email!");
            return false;
        }
        if(!email.contains("@")){
            System.err.println("Email có định dạng không phù hợp!");
            return false;
        }
        if(!email.matches("^\\D*\\d*[@][a-z]*[.][a-z]*$")){
            System.err.println("Không phải là định dạng của email!");
            return false;
        }
        //trả ra true và set nếu nó hợp lí
        this.email = email;
        return true;
    }
    
    //vì có phểu rỗng nên ta có hàm inputInfor và nhờ có set thông minh nên ta chặn
    //nhập sai được
    @Override
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        //kêu thằng cha nhập các thông tin của nó
        super.inputInfor();
        boolean isTrue = false;
        System.out.println("Nhập vào id đi: ");
        do{
            String keyId = sc.nextLine();
            isTrue = setId(keyId);
        }while(!isTrue);//nếu ra false thì !false = true và bắt nhập lại còn đúng thì thôi
        isTrue = false;
        System.out.println("Nhập vào gpa đi: ");
        do{
            double keyGpa = Double.parseDouble(sc.nextLine());
            isTrue = setGpa(keyGpa);
        }while(!isTrue);//nếu ra false thì !false = true và bắt nhập lại còn đúng thì thôi
        isTrue = false;
        System.out.println("Nhập vào email đi: ");
        do{
            String keyEmail = sc.nextLine();
            isTrue = setEmail(keyEmail);
        }while(!isTrue);//nếu ra false thì !false = true và bắt nhập lại còn đúng thì thôi
    }

    @Override
    public void showInfor() {
        //kêu cha in thông tin của ổng đi
        super.showInfor();
        //độ lại của thằng con
        String str  = String.format("|%-15s|%5.2f|%-15s|\n", id, gpa, email);
        //để dấu \n giúp cho in xong thì xuống hàng
        //tại làm màu mè chứ ta có thể lấy bên kia qua đây rồi chỉnh là đc
        System.out.printf(str);
        //println: in xong tự xuống hàng còn printf là in trên cùng một hàng
    }
    
    //hàm tìm ra những thằng có học bỗng
    public boolean hasScholarship(){
        return gpa >= 8;
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