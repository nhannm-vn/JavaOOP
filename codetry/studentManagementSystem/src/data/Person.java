package data;

import java.util.Scanner;

public class Person {
    //props
    private String name;
    private String gender;
    private int yob;
    
    //phểu có đối số

    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    
    //phểu không có đối số vậy phải cần hàm nhập thông tin

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
        System.out.println("Nhập vào tên: ");
        this.name = sc.nextLine();//nhập chuỗi
        
        System.out.println("Nhập vào giới tính: ");
        this.gender = sc.nextLine();
        
        System.out.println("Nhập vào năm sinh: ");
        this.yob = Integer.parseInt(sc.nextLine());
        //vì sợ nhập giữa chữ và số bị dính rác buffer nên nhờ cơ chế wrapper 
        //ép tất cả chuỗi nhập vào về kiểu nguyên hết
        
        
        
        
    }
    
    public void showInfor(){
        //giúp in ra dễ dàng trên 1 hàng
        String str = String.format("|%s|%s|%d|", name, gender, yob);
        System.out.printf(str);//đổi thành in ko xuống hành cho hợp với cha
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