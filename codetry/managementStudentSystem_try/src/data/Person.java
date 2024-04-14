package data;

import java.util.Scanner;

public class Person {
    //Props
    private String name;
    private String gender;
    private int yob;
    
    //constructor

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
    
    //method nhập thông tin người dùng
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        //nhập name
        while(true){
            System.out.println("Nhập vào tên: ");
            this.name = sc.nextLine();
            //String inpName = name;
            boolean isValid = name.matches("^([A-Z][a-z]*)*(\\s[A-Z][a-z]*)*$");
            //^([A-Z][a-z]*)*(\s[A-Z][a-z]*)*$
            if(isValid){
                break;
            }else{
                System.err.println("Tên không hợp lí!!!");
            }
        }
        //nhập gender
        while(true){
            System.out.println("Nhập giới tính: ");
            this.gender = sc.nextLine();
            //String inpGender = gender;
            boolean isGender = gender.matches("^N(am|u)$");
            if(isGender){
                break;
            }else{
                System.err.println("Giới tính không hợp lí!!!");
            }
        }
        
        //nhập yob
        while(true){
            System.out.println("Nhập năm sinh: ");
            this.yob = Integer.parseInt(sc.nextLine());
            //object mới chấm đc, primitive thì không
            if(this.yob < 0){
                System.err.println("Năm sinh không hợp lí!!!");
            }else{
                break;
            }
        }
    }
    
    //method showInfor
    public void showInfor(){
        String str = String.format("|%s|%s|%d|", name, gender, yob);
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