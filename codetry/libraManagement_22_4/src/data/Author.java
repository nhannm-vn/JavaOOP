package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //tạo ra các prop cho author
    private String name;
    private String nickName;
    private int yob;
    
    //tạo phểu có full đối số

    public Author(String name, String nickName, int yob) {
        this.name = name;
        this.nickName = nickName;
        this.yob = yob;
    }
    
    //tạo phểu không có đối số + cần thêm hàm inputInfor()

    public Author() {
    }
    
    //tạo phểu chỉ nhận vào nickName
    //này đanh chdo trường hợp nhập vào sách mới chưa có tác giả và cần thêm vào
    //một author mới. Nhưng vì đã có nickName nên phểu này giúp không nhập nickName trùng
    public Author(String nickName) {
        this.nickName = nickName;
    }
    
    //tạo getter

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public int getYob() {
        return yob;
    }
    
    //tạo hàm nhập thông tin tác giả
    public void inputInfor(){//hàm này chỉ nhập name và yob để xài cho phểu có nickname rồi
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên tác giả: ");
        this.name = sc.nextLine();
        
        System.out.println("Nhập vào năm sinh tác giả:");
        this.yob = Integer.parseInt(sc.nextLine());//này để tránh trôi lệnh
        
    }
    
    //hàm nhập thông tin tác giả nhưng có check 
    //nếu đã có tác giả trong list rồi thì ép nhập lại
    //nếu chưa có thì cho nhập vô
    public void inputInfor(ArrayList<Author> auList){//nhận vào một list tác giả để kiểm tra
        Scanner sc = new Scanner(System.in);
        
        String keyNickName;
        
        /*
        tạo hàm nhập thông tin tác giả
        nhưng nếu tác giả đã tồn tại trong danh sách thì k cho
        ép nhập lại
        */
        boolean isDup = false;//duplicate check trùng lặp
        while(true){
            isDup = false;//nếu không để đây thì khi nhập sai sẽ bị bug
            System.out.println("Nhập vao nickname(bút danh) của tác giả: ");
            keyNickName = sc.nextLine();
            for (Author author : auList) {
                if(author.getNickName().equals(keyNickName)){
                    isDup = true;
                }
            }
            if(!isDup){//nếu chưa có thì làm
                this.nickName = keyNickName;
                inputInfor();//nhập vào hai thông tin còn lại
                break;
            }else{
                System.out.println("Nickname(bút danh) đã có người sử dụng rồi!!!");
            }
        }
        
    }
    
    //hàm in ra thông tin
    public void showInfor(){
        System.out.printf("|%-30s|%-25s|%4d|\n", name, nickName, yob);
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