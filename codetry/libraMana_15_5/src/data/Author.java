package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //props
    private String name;
    private String nickName;
    private int yob;
    
    //constructor
    //phểu có đầy đủ đối số, khi ta rót full giá trị sẽ đc 1 tác giả hoàn chỉnh
    public Author(String name, String nickName, int yob) {
        this.name = name;
        this.nickName = nickName;
        this.yob = yob;
    }
    //phểu không có đối số. Thì ta cần phải thêm method nhập thêm thông tin vào

    public Author() {
    }
    
    //phểu có đối số nickName ta chỉ rót name và yob còn nickName có sẵn, dành cho
    //khi check nickName của book. Nếu tác giả có rồi thì thôi. Nếu sách chưa có
    //tác giả thì ta phải thêm mới tác giả. Mà book thì có sẵn nickName nên ta
    //chỉ thêm 2 props kia thôi nên mới có phểu chỉ có nickName

    public Author(String nickName) {
        this.nickName = nickName;
    }
    //method getter

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public int getYob() {
        return yob;
    }
    
    
    //method inputInfor() dành cho trường hợp có sẵn nickname rồi
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên tác giả: ");
        this.name = sc.nextLine();
        System.out.println("Nhập vào năm sinh tác giả: ");
        this.yob = Integer.parseInt(sc.nextLine());
    }
    
    /*
    tạo hàm nhập thông tin tác giả
    nhưng nếu tác giả đã tồn tại trong danh sách thì k cho
    ép nhập lại
    */
    //này nhập full thông tin. Nhưng nếu tác giả đã nằm trong list thì ta bắt nhập lại
    public void inputInfor(ArrayList<Author> auList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào bút danh(nickName) của tác giả: ");
        while(true){
            String keyNickName = sc.nextLine();
            boolean isDup = false;
            for (Author item : auList) {
                if(item.nickName.equals(keyNickName)){
                    isDup = true;
                }
            }
            if(!isDup){
                this.nickName = keyNickName;
                break;
            }else{
                System.out.println("NickName đã có người sử dụng rồi!!!");
            }
        }
        inputInfor();
        
    }
    public void showInfor(){
        String str = String.format("%-25s|%-25s|%10d"
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