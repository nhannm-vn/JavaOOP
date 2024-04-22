package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //props
    private String name;
    private String nickname;
    private int yob;
    
    //tạo phểu có đối số full. Để nhận đầy đủ thông tin từ người dùng truyền

    public Author(String name, String nickname, int yob) {
        this.name = name;
        this.nickname = nickname;
        this.yob = yob;
    }
    
    //tạo phểu không có đối số. Cần có thêm hàm inputInfor()
    //cái phểu rỗng(khi muốn người dùng nhập vào) + đi kèm hàm inputInfor()
    //phểu rỗng + inputInfor()(auList): nhập name, nickname, yob
    public Author() {
    }
    
    //tạo phểu có đối số duy nhất là nickname

    public Author(String nickname) {
        this.nickname = nickname;
    }
    
    //getter

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getYob() {
        return yob;
    }
    
    //hàm nhập thông tin tác giả dành cho phểu có sẵn nickname
    //chỉ cần nhập thêm name và yob
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        //nhập tên tác giả
        System.out.println("Nhập vào tên tác giả: ");
        this.name  = sc.nextLine();
        
        //nhập yob
        System.out.println("Nhập vào năm sinh của tác giả: ");
        this.yob = Integer.parseInt(sc.nextLine());
        //ép kiểu để tránh trôi lệnh khi nhập xen kẽ giữa số và chữ
        
    }
    //hàm nhập, nhưng nếu tác giả đã tồn tại trong danh sách thì k cho ép nhập lại
    //Overload: cùng tên nhưng khác đầu vào
    public void inputInfor(ArrayList<Author> auList){//nhập thêm cái mảng để kiểm tra nickname
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào nickname(bút danh) của tác giả: ");
        //tạo ra vòng lặp để kiểm tra xem nickname có nằm trong list chưa
        //nếu có rồi thì bắt nhập lại đến khi ko trùng
        while(true){
            String keyNickname = sc.nextLine();
            boolean isDup = false;//duplicate: kiểm tra có trùng hay không
            for (Author author : auList) {
                if(author.getNickname().equals(keyNickname)){
                    isDup = true;
                }
            }
            if(!isDup){//nếu không có trùng thì thực hiện(gán nickname)
                this.nickname = keyNickname;
                break;
            }else{
                System.out.println("Nickname đã có người sử dụng!");
            }
        }
        //sử dụng lại nhập name và yob từ hàm inputInfor() trên
        inputInfor();
    }
    
    //hàm in ra các giá trị showInfor()
    public void showInfor(){
        System.out.printf("|%-30s|%-30s|%4d\n",  name, nickname, yob);
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