package data;

import java.util.Scanner;

public class Person {
    //tạo props
    private String name;
    private String gender;
    private int yob;
    //tạo cái phểu
    //phểu có đầy đủ đối số
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
    
    //vì ta có phểu không có đối số cho nên ta  cần hàm inputInfor()
    
    public void inputInfor(){
        Scanner sc  = new Scanner(System.in);
        //input name
        System.out.println("Nhập vào tên sinh viên: ");
        this.name =  sc.nextLine();
        
        //input gender
        System.out.println("Nhập vào giới tính: ");
        this.gender = sc.nextLine();
        
        //input yob
        System.out.println("Nhập vào năm sinh: ");
        this.yob = Integer.parseInt(sc.nextLine());
        //ép kiểu để sợ bị trôi lệnh
    }
    
    //method showInfor()
    public void showInfor(){
        //in theo kiểu format thông qua String.format
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