/*
Author la cai khuon chuyen dung de duc ra cac anh tac gia
 */
package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //props
    private String name;
    private String nickName;
    private int yob;
    public Scanner sc = new Scanner(System.in);
    //constructor

    public Author(String name, String nickName, int yob) {
        this.name = name;
        this.nickName = nickName;
        this.yob = yob;
    }
    
    //pheu rong + ham inputInfor()
    //pheu nay de tao ra thang tac gia voi day du thong tin
    public Author() {
    }
    
    //pheu co doi so la nickName
    //giup ta co the khi tao mot cuốn sách mà chưa có tác giả thì
    //vì book đã có nickname nên k cần thêm nữa
    public Author(String nickName) {
        this.nickName = nickName;
    }
    
    //getter

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public int getYob() {
        return yob;
    }
    
    //method inputInfor()
    public void inputInfor(){//dành cho phểu nhận vào sẵn nickName
        System.out.println("Nhap vao ten cua tac gia: ");
        this.name = sc.nextLine();
        System.out.println("Nhap vao nam sinh tac gia: ");
        this.yob = Integer.parseInt(sc.nextLine());
    }
    //method inputInfor() overload giup nhap full thong tin nhưng kiểm tra 
    //trong mảng tác giả để nhập trùng thì ép bắt nhập lại
    public void inputInfor(ArrayList<Author> auList){
        boolean isDup;//kiem tra nickName co trung hay k
        //trung thi ep bat nhap lai
        String nickName;
        System.out.println("Nhap vao nickname cua tac gia: ");
        do{
            isDup = false;
            nickName = sc.nextLine();
            for (Author author : auList) {
                if(author.getNickName().equals(nickName)){
                    isDup = true;
                    System.out.println("Ten tac gia da duoc su dung!");
                }
            }
        }while(isDup);
        this.nickName = nickName;
        //Overload 
        inputInfor();//nhap vao 2 cai con lai
    }
    
    //method showInfor()
    public void showInfor(){
        String str = String.format("%-20s|%-20s|%4d"
                        , name, nickName, yob);
        System.out.println(str);
    }
}
/*
Author
    name nickname old birthday;
    tạo phểu hàm không đối số
    tạo phểu có đối số 
    tạo phểu có đối số là nickname
    tạo getter không tạo setter
    tạo hàm nhập thông tin tác giả
    nhưng nếu tác giả đã tồn tại trong danh sách thì k cho
    ép nhập lại
    tạo hàm showInfor
*/