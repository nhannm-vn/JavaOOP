package data;

import java.util.Scanner;

public class Person {
    //props của riêng nó: 
    private String name;
    private String gender;
    private int yob;
    
    //constructor của riêng nó
    //có full đối số

    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    
    //phểu không có đối số + hàm nhập vào thông tin

    public Person() {
    }
    //method
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
    //độ thêm setter thông minh

    public boolean setName(String name) {
        if(name.length() <= 0){
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        if(!name.matches("([A-Z][a-z]*)*( [A-Z]*[a-z]*)*$")){
            System.err.println("Tên không hợp lí!!!");
            return false;
        }
        this.name = name;
        return true;
    }
    
    public boolean setGender(String gender) {
        if(gender.length() <= 0){
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        this.gender = gender;
        return true;
    }

    public boolean setYob(int yob) {
        if(yob <= 0){
            System.err.println("Không phù hơp!!!");
            return false;
        }
        this.yob = yob;
        return true;
    }
    
    //method nhập thông tin người dùng do có cái phểu rỗng
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên: ");
        while(!setName(sc.nextLine()));
        
        System.out.println("Nhập vào giới tính: ");
        while(!setGender(sc.nextLine()));
        
        System.out.println("Nhập vào năm sinh: ");
        while(!setYob(Integer.parseInt(sc.nextLine())));//tránh lỗi buffer
    }
    //method showInfor()
    public void showInfor(){
        String str = String.format("|%-25s|%-10s|%4d", 
                                    name, gender, yob);
        System.out.printf(str);//sửa lại để trên 1 dòng
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