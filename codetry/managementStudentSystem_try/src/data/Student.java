package data;

import java.util.Scanner;

public class Student extends Person {
    //props riêng
    private String id;
    private float gpa;
    private String email;
    
    //constructor

    public Student(String id, float gpa, String email, String name, String gender, int yob) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    
    //phểu ko đối số

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
    //nhập đúng thì tao cho mày set lại. Và trả ra true
    //còn sai thì trả ra false
    public boolean setId(String id) {
        //không được bỏ trống 
        if(id.length() <= 0){
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        if(!id.matches("^[S](S|E)\\d{6}$")){
            System.err.println("ID phải đầy đủ!!!");
            return false;
        }
        this.id = id;
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
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        if(!email.contains("@")){
            System.err.println("Không hợp lí!!!");
            return false;
        }
        if(!email.matches("^[a-z]*\\d{0,6}[@][a-z]*[.][a-z]*([.][a-z]*)*$")){
            System.err.println("Email không hợp lệ!!!");
            return false;
        }
        this.email = email;
        return true;
    }
    
    //inputInfor
    @Override
    public void inputInfor(){
        //nhờ thằng cha nhập phần của riêng nó
        super.inputInfor();
        //scanner
        Scanner sc = new Scanner(System.in);
        
        //nhập id
        System.out.println("Nhập id: ");
        while(!setId(sc.nextLine()));
        
        //nhập gpa
        System.out.println("Nhập gpa: ");
        while(!setGpa(Float.parseFloat(sc.nextLine())));
        
        //nhập email
        System.out.println("Nhập email: ");
        while(!setEmail(sc.nextLine()));
        
        
    }
    
    //showInfor
    @Override
    public void showInfor(){
        super.showInfor();
        String str = String.format("|%s|%.2f|%s|\n", id, gpa, email);
        System.out.printf(str);
    }
}
/*
Student class
    sử dụng kế thừa để có name, gender, yob, của Person
    riêng Student thì muốn có thêm id, gpa, email
    getter và có setter thông minh
    showInFor
*/