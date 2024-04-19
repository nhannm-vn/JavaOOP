package data;

import java.util.Scanner;

public class Person {
    //properties
    private String name;
    private String gender;
    private int yob;
    
    //phểu có đối số:

    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    //phểu không có đối số
    //hiện tượng Overload: nó giống nhau về tên khác parameter, 2 cách xài
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
    
    //vì ta có phểu không có đối số. Nên ta cần thêm hàm nhập thông tin 
    public void inputInfor(){
        Scanner sc =  new Scanner(System.in);
        //name
        System.out.println("Nhập vào tên sinh viên: ");
        this.name = sc.nextLine();
        //gender
        System.out.println("Nhập vào giới tính: ");
        this.gender = sc.nextLine();
        //yob
        System.out.println("Nhập vào năm sinh: ");
        this.yob  = Integer.parseInt(sc.nextLine());
        //vì sợ lỗi buffer mà bên Java chúng ta không có fflush nên phải
        //xài ép kiểu thông qua wrapper
        //nhờ vậy mà ta biến tất cả chuỗi về kiểu int hết
        
    }
    //method showInfor
    public void showInfor(){
        //in ra trên một dòng xài kỹ thuật String.format
        String str = String.format("|%s|%s|%d", name, gender, yob);
        System.out.printf(str);//in trên cùng một dòng với thằng con
        //sau khi thằng con in xong thằng con sẽ xuống dưới để tiếp tục menu
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