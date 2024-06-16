package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //prop
    private String name;
    private String nickName;
    private int yob;
    public static Scanner sc = new Scanner(System.in);
    //phểu có đầy đủ đối số

    public Author(String name, String nickName, int yob) {
        this.name = name;
        this.nickName = nickName;
        this.yob = yob;
    }
    
    //phểu không có đối số
    //thì cần thêm hàm inputInfor() nhận vào full thông tin

    public Author() {
    }
    
    //phểu có đối số là nickName
    //nhận vào 2 thông tin thôi là name và yob

    public Author(String nickName) {
        this.nickName = nickName;
    }
    
    //hàm nhập vào thông tin khi đã có nickName rồi
    public void inputInfor(){
        System.out.println("Nhập vào tên của tác giả: ");
        this.name = sc.nextLine();
        System.out.println("Nhập vào năm sinh: ");
        this.yob = Integer.parseInt(sc.nextLine());
    }
    
    //hàm nhập vào full thông tin khi chưa có nickName thì phải check coi tác giả
    //đã có trong danh sách chưa có rồi thì không cho và ép nhập lại
    public void inputInfor(ArrayList<Author>auList){
        //nhập vào nickname
        String keyNickName;
        boolean isDup;
        System.out.println("Nhập vào nickName(bút danh) của tác giả: ");
        do{
            isDup = false;
            keyNickName = sc.nextLine();
            for (Author item : auList) {
                if(item.getNickName().equals(keyNickName)){
                    isDup = true;
                }
            }
            if(isDup){
                System.out.println("nickName đã được sử dụng mời nhập lại!!!");
            }
        }while(isDup);
        this.nickName = keyNickName;
        
        //nhập 2 thông tin còn lại
        inputInfor();
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
    
    //hàm showInfor()
    public void showInfor(){
        String str = String.format("%-20s|%-15s|%4d"
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