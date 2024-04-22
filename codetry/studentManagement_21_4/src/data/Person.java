package data;
//tạo khuôn Person. Tạo ra trước vì nó là cha

import java.util.Scanner;

public class Person {
    //tạo ra các props
    private String name;
    private String gender;
    private int yob;
    
    //tạo phểu có đối số và không có đối số
    //phểu không có đối số để dành cho người ta tạo ra person mà bỏ trống
    //lúc đó ta phải + method inputInfor()
    
    //constructor full đối số

    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    
    //constructor không có đối số

    public Person() {
    }
    
    //getter

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getYob() {
        return yob;
    }
    
    //method nhập thông tin của người dùng do có cái phểu rỗng
    public void inputInfor(){
        //Scanner
        Scanner sc = new Scanner(System.in);
        //nhập vào name
        System.out.println("Nhập vào tên: ");
        this.name = sc.nextLine();
        
        //Nhập vào giới tính: 
        System.out.println("Nhập vào giới tính: ");
        this.gender = sc.nextLine();
        
        //Nhập vào năm sinh
        System.out.println("Nhập vào năm sinh: ");
        this.yob = Integer.parseInt(sc.nextLine());//ép tất cả về số nguyên
    }
    //method showInfor()
    
    public void showInfor(){
        //xài String.format để in trên một dòng cho tiện
        String str = String.format("|%s|%s|%d", name, gender, yob);
        System.out.printf(str);
    }
    
}
/*
Person class
    bao gồm name, gender, yob
    có phễu có đối số, và không có đối số
    có getter và không có setter
    method showInFor
    method nhập thông tin người dùng

*/