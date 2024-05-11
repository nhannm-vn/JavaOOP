package data;

import java.util.Scanner;

public class Student extends Person{
    //props riêng
    private String id;
    private float gpa;
    private String email;
    
    //constructor
    //có đối số
    //phải đổi para của cha lên trước ưu tiên người già
    public Student(String name, String gender, int yob, String id, float gpa, String email) {
        super(name, gender, yob);//gọi cái phểu của cha
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    
    //phểu không có đối số thì cần thêm hàm nhập vào thông tin
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
    
    /*
    setter thông minh là kiểm tra xem thông tin nhận vào có valid hay không. Nếu
    valid thì ta cho xét và trả ra true. Ngược lại nếu không valid thì ta trả ra false
    và không cho set
    */

    public boolean setId(String id) {
        if(id.length() <= 0){
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        if(!id.matches("[S][E]\\d{6}")){
            System.err.println("Id phải có dạng SEDDDDDD với D là số!!!");
            return false;
        }
        this.id = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("gpa không hợp lí!!!");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public boolean setEmail(String email) {
        if(email.length() <= 0){
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        if(!email.contains("@")){
            System.err.println("Email không hợp lí!!!");
            return false;
        }
        if(!email.matches("^[a-z]*[0-9]*[@][a-z]*[.][a-z]*([.][a-z]*)*$")){
            System.err.println("Email không hợp lí!!!");
            return false;
        }
        this.email = email;
        return true;
    }
    
    
    
    //method nhập vào thông tin người dùng
    //nhờ ta có setter thông minh. Nên khi nhập thông tin ta bắt người dùng
    //phải nhập thông tin valid nếu không thì ta sẽ bắt nhập lại đến valid thì thôi
    @Override
    public void inputInfor(){
        //nhờ cha nhập vào các thông tin của cha trước
        super.inputInfor();
        //nhập các thông tin của riêng con
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào IdStudent: ");
        while(!setId(sc.nextLine()));//nếu không ra đúng thì làm hoài nếu đúng thì giá trị được rót vào props
        
        System.out.println("Nhập vào gpa: ");
        while(!setGpa(Float.parseFloat(sc.nextLine())));
        
        System.out.println("Nhập vào email: ");
        while(!setEmail(sc.nextLine()));
    }
    
    //showInfor()
    @Override
    public void showInfor(){
        //gọi cha ra in các thông tin của ổng
        super.showInfor();
        String str = String.format("%-15s|%7.2f|%-20s|\n"
                                    , id, gpa, email);
        System.out.printf(str);//in đồng nhất với Person mới xuống hàng
    }
    
    public boolean hasScholarship(){
        if(this.gpa > 8){
            return true;
        }
        return false;
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