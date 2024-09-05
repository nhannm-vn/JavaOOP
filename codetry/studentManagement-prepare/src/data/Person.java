package data;
//vì student là person nên person là cha code nó trước

import java.util.Scanner;

public class Person {
    //properties
    protected String name;
    protected String gender;
    protected int yob;
    
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
    //vì ta có cái phểu rỗng không có đối số nên cần method nhập thông tin
    public void inputInfor(){
        //scanner
        Scanner sc = new Scanner(System.in);
        //nhập vào name
        System.out.println("Nhập vào name đi: ");
        this.name = sc.nextLine();
        //nhập vào giới tính đi
        System.out.println("Nhập vào giới tính đi: ");
        this.gender = sc.nextLine();
        //nhập vào yob đi, coi chừng dính dấu xuống hàng
        System.out.println("Nhập vào yob đi: ");
        this.yob = Integer.parseInt(sc.nextLine());
        //vì sợ lỗi buffer mà bên Java chúng ta không có fflush nên phải
        //xài ép kiểu thông qua wrapper
        //nhờ vậy mà ta biến tất cả chuỗi về kiểu int hết
    }
    
    //method showInfor
    public void showInfor(){
        String str = String.format("%-15s|%-15s|%d", name, gender, yob);
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