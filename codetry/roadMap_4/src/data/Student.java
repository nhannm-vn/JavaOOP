package data;

import java.util.Scanner;


public class Student extends Person {
    //props riêng
    private String id;
    private float gpa;
    private String gmail;
    
    //constructor

    public Student(String name, String gender, int yob, String id, float gpa, String gmail) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.gmail = gmail;
    }
    
    //constructor rong

    public Student() {
    }
    
    //getter

    public String getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public String getGmail() {
        return gmail;
    }
    
    //setter thông minh: là setter nhận vào thông tin kiểm tra đúng yêu cầu mới 
    //cho set giá trị và trả ra true còn nếu k valid thì trả ra false

    public boolean setId(String id) {
        if(id.isEmpty()){
            System.err.println("Not be empty!");
            return false;
        }
        if(!id.matches("^[S][E]\\d{6}$")){
            System.err.println("The id need matches SEXXXXXX!");
            return false;
        }
        this.id = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("The gpa must between 0 and 10");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public boolean setGmail(String gmail) {
        if(!gmail.contains("@")){
            System.err.println("Gmail not valid!");
            return false;
        }
        if(!gmail.matches("^[a-z]*[0-9]*[@][a-z]*[.][a-z]*[.]*([a-z])*$")){
            System.err.println("Gnail not valid!");
            return false;
        }
        if(gmail.isEmpty()){
            System.err.println("Not be empty!!");
        }
        this.gmail = gmail;
        return true;
    }
    
    //inputInfor
    @Override
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        //nho thang cha nhap cac thong tin cua ong
        super.inputInfor();
        System.out.println("Input your id: ");
        while(!setId(sc.nextLine()));//ra true thi dung lai
        
        System.out.println("Input your gpa: ");
        while(!setGpa(Float.parseFloat(sc.nextLine())));//ep ve so thuc de tranh troi lenh
        
        System.out.println("Input your gmail: ");
        while(!setGmail(sc.nextLine()));
        
    }
    
    //showInfor
    @Override
    public void showInfor(){
        //cha oi in cho con di
        super.showInfor();
        String str = String.format("%15s|%6.2f|%20s|\n", id, gpa, gmail);
        System.out.printf(str);
    }
    
    //kiem tra coi co hc bong k
    public boolean hasScholarship(){
        return gpa > 8;
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