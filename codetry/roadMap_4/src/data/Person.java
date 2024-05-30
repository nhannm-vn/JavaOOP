package data;

import java.util.Scanner;
import utils.Inputter;

public class Person {
    //props
    private String name;
    private String gender;
    private int yob;
    //constructor

    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    
    //phểu không có đối số thì yêu cầu thêm hàm nhập inputInfor()

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
    
    //method nhập thông tin từ người dùng do xài phểu rỗng
    public void inputInfor(){
        this.name = Inputter.getString("Input your name: ", "Not be empty!");
        this.gender = Inputter.getString("Input your gender: ", "Not be empty!");
        this.yob = Inputter.getAnInteger("Input your yob: ", "The yob must be between 1999 and 2004"
                                                                , 1999, 2004);
    }
    
    //method showInfor()
    public void showInfor(){
        String str = String.format("%10s|%10s|%4d"
                                            , name, gender, yob);
        System.out.println(str);
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