package data;

//sau khi tạo xong class Person giờ ta tới Student

import java.util.Scanner;

//cho nhận cha để thừa hưởng thuộc tính của cha
public class Student extends Person {
    //thuộc tính riêng chỉ có Student có
    //properties
    private String id;
    private float gpa;
    private String email;
    
    //phểu có đối số và không có đối số
    //phểu có full đối số

    //cha mày, nên mày phải đưa cha lên trước
    public Student(String name, String gender, int yob, String id, float gpa, String email) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    //phểu không có đối số(nếu vậy cần thêm hàm inputInfor())

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
    setter thông minh là setter nhập vào một thông tin. Check nếu nó valid
    thì mới set sau đó trả ra true
    Nếu không valid thì không set và trả ra false
    */

    public boolean setId(String id) {
        if(id.length() <= 0){
            System.err.println("Id không được bỏ trống!");
            return false;
        }
        if(!id.matches("^SE\\d{6}$")){
            System.err.println("Id phải có dạng SEDDDDDD với D là số!");
            return false;
        }
        this.id = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(this.gpa < 0 || this.gpa > 10){
            System.err.println("Gpa không hợp lí!");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public boolean setEmail(String email) {
        if(email.length() <= 0){
            System.err.println("Không được bỏ trống!");
            return false;
        }
        if(!email.contains("@")){
            System.err.println("Email không hợp lệ!!!");
            return false;
        }
        if(!email.matches("^[a-z]*\\d{0,6}[@][a-z]*[.][a-z]*([.][a-z]*)*$")){
            System.err.println("Email không hợp lệ!!!");
            return false;
        }
        this.email = email;
        return true;
    }
    //hàm nhập vào thông tin do có phểu rỗng
    @Override//độ lại của cha person
    public void inputInfor(){
        //gọi cha để nhập các giá trị của cha
        super.inputInfor();
        //nhập các giá trị riêng của con
        //nhờ vào có setter thông minh ra sẽ bắt nó nhập hợp lí
        //nếu nhập tào lao cho mày nhập đến ngày mai
        Scanner sc = new Scanner(System.in);
        //nhập vào id
        System.out.println("Nhập vào IdStudent: ");
        while(!setId(sc.nextLine()));//nếu nhập đúng tao sẽ cho set và dừng lại
        //không thì lặp lại cho tao
        
        //nhập vào gpa
        //cần xài wrapper để tránh buffer
        System.out.println("Nhập vào điểm gpa: ");
        while(!setGpa(Float.parseFloat(sc.nextLine())));
        System.out.println("Nhập vào email đi: ");
        //nhập vào email
        while(!setEmail(sc.nextLine()));
        
    }
    //hàm in ra các thông tin
    @Override
    public void showInfor(){
        //gọi thằng cha ra nhờ nó in ra các cái nó có
        super.showInfor();
        //in ra những cái riêng của con
        //để dồng nhất ta qua person đổi thành in trên cùng một dòng
        //bên student in xong cùng dòng với person rồi mới xuống sau
        String str = String.format("|%s|%.2f|%s|\n", id, gpa, email);
        System.out.printf(str);
    }
    
    //kiểm tra những thằng có gpa > 8 thì trả ra true để xài bên kia
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