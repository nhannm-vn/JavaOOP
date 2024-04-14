package data;

import java.util.Scanner;

public class Person {
    //props
    private String name;
    private String gender;
    private int yob;
    
    //constructor
    //phểu có đối số
    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    
    //phểu không có đối số

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
    
    //method nhập thông tin người dùng
    
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        //nhập vào name
        //bình thường đụng tới props phải có thằng chịu trách nhiệm
        //nhưng xài trong class đó thì chỉ cần this. hoặc khỏi cx đc
        System.out.println("Nhập vào tên: ");
        this.name = sc.nextLine();
        
        //nhập vào gender
        System.out.println("Nhập vào giới tính: ");
        this.gender = sc.nextLine();
        
        //nhập vào yob
        //sợ lỗi buffer nên ép chuỗi về nguyên cho chắc thông qua wrapper
        System.out.println("Nhập vào năm sinh: ");
        this.yob = Integer.parseInt(sc.nextLine());
        
    }
    
    //method showInfor
    public void showInfor(){
        String str = String.format("|%s|%s|%d|", name, gender, yob);
        System.out.printf(str);//đổi là printf để cho cùng 1 dòng
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