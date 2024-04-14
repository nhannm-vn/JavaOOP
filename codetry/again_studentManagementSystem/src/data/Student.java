package data;

import java.util.Scanner;

public class Student extends Person{
    //props riêng
    private String id;
    private float gpa;
    private String email;
    
    //phểu
    //của cha phải quý phải đưa lên trên
    public Student(String name, String gender, int yob,
            String id, float gpa, String email) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    
    //phểu k có đối số

    public Student() {
    }
    
    //method getter

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

    public boolean setId(String id) {
        if(id.length() <= 0){
           System.err.println("ID không được bỏ trống!!!");
           return false;
        }
        if(!id.matches("^[S][E]\\d{7}")){
            System.err.println("Id phải có dạng SEDDDDDDD với D là số");
            return false;
        }
        this.id = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("GPA không hợp lí!!!");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public boolean setEmail(String email) {
        if(!email.contains("@")){
            System.err.println("Email không hợp lệ!!!");
            return false;
        }
        if(email.length() <= 0){
            System.err.println("Email không được bỏ trống!!!");
            return false;
        }
        if(!email.matches("^([a-z])*([a-z]*[0-9]*)*[@]gmail[.]com$")){
            System.err.println("Email không hợp lệ!!!");
            return false;
        }
        this.email = email;
        return true;
    }
    
    //hàm nhập giá trị cho phểu đối số
    @Override
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        //kêu thằng cha nhờ nó nhập mấy cái của nó khỏi copy rồi mở protected
        super.inputInfor();
        //tới mình nhờ có setter nên mình sẽ bắt nhập chính xác 
        
        //nhập id
        System.out.println("Nhập IDStudent: ");
        /*
        while(true){
            String inpId = sc.nextLine();
            boolean isValid = setId(inpId);
            if(isValid) break;
        }
        */
        //nhập sai thì bắt nhập chetme mày
        while(!setId(sc.nextLine()));
        
        //nhập gpa
        System.out.println("Nhập GPA: ");
        /*
        while(true){
            float inpGpa = sc.nextFloat();
            boolean isValid = setGpa(inpGpa);
            if(isValid) break;
        }*/
        //nhập giữa chữ và chuỗi thì phải cẩn thận ép kiểu nhé
        while(!setGpa(Float.parseFloat(sc.nextLine())));
        
        //nhập email
        System.out.println("Nhập email: ");
        while(!setEmail(sc.nextLine()));
    }
    //showInfor
    //lấy của cha nó xong độ lại
    @Override
     public void showInfor(){
        //bắt ổng in ra luôn để khỏi phải mở protected
        super.showInfor();
        //in ra những gì mình có
        String str = String.format("%s|%.2f|%s|\n", id, gpa, email);
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