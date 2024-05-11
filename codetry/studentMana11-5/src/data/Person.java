/*
class Person

 */
package data;

import java.util.Scanner;

public class Person {
    //props
    private String name;
    private String gender;
    private int yob;
    
    //constructor
    //constructor full đối số: khi ta rót vào full thông tin sẽ đúc ra được một
    //thằng person đầy đủ
    //hiện tượng Overload: nó giống nhau về tên khác parameter, 2 cách xài
    //diễn ra trong cùng class
    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    
    //method không có đối số. Thì ta cần thêm method inputInfor() nó sẽ giúp 
    //ta nhập thông tin vào

    public Person() {
    }
    
    //method inputInfor() do có phểu không có đối số
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        //Nhập vào name
        System.out.println("Nhập vào tên: ");
        this.name = sc.nextLine();
        
        //Nhập vào gender
        System.out.println("Nhập vào giới tính: ");
        this.gender = sc.nextLine();
        
        //Nhập vào yob: 
        System.out.println("Nhập vào năm sinh: ");
        this.yob = Integer.parseInt(sc.nextLine());
        //ép kiểu để tránh buffer
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
    
    //method in ra thông tin Person
    public void showInfor(){
        String str = String.format("%-25s|%-10s|%4d|"
                                    , name, gender, yob);
        System.out.printf(str);//in xong không xuống hàng mà đợi ghép thằng kia
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