package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //Tạo các props cho Author
    private String name;
    private String nickName;
    private int yob;
    
    //tạo ra cái phểu có full đối số không cần có hàm nhập thêm

    public Author(String name, String nickName, int yob) {
        this.name = name;
        this.nickName = nickName;
        this.yob = yob;
    }
    //tạo ra phểu có đối số là nickname
    /*
    phểu này dành cho trường hợp nhập mới một cuốn sách mà chưa có tác giả
    Vì trong tạo cuốn sách đã có nickname nên ta có phểu nhận vào sẵn nickname
    luôn. Vậy ta chỉ cần hàm inputInfor() cho 2 thuộc tính
    */
    public Author(String nickName) {
        this.nickName = nickName;
    }
    
    //phểu không có đối số dành cho rót full thông tin

    public Author() {
    }
    
    //tạo method getter

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public int getYob() {
        return yob;
    }
    
    //method nhập cho phểu có sẵn nickName
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên tác giả(name): ");
        this.name = sc.nextLine();
        
        System.out.println("Nhập vào năm sinh tác giả: ");
        this.yob = Integer.parseInt(sc.nextLine());
    }
    
    //method nhập vào thông tin full của tác giả dành cho phểu không có đối số
    //những khi nhập vào nếu tác giả đã tồn tại thì bắt nhập lại
    //kiểm tra trong list coi có tác giả chưa? Nếu có rồi thì bắt nhập lại
    //check trùng bằng nickName
    public void inputInfor(ArrayList<Author> auList){//overload
        //nhập vào nickName tác giả
        Scanner sc = new Scanner(System.in);
        String key;
        //check trong list xem có chưa
        //nếu có rồi thì bắt nhập lại
        while(true){
            boolean isDup = false;//phải để trong while để kt nếu trùng thì như ban đầu
            System.out.println("Nhập vào bút danh(nickName) tác giả: ");
            key = sc.nextLine();
            for (Author author : auList) {
                if(author.getNickName().equals(key)){
                    isDup = true;
                }
            }
            if(!isDup){//nếu chưa có thì làm xong dừng. Có rồi thì hỏi tiếp
                this.nickName = key;
                break;
            }else{
                System.out.println("Tác giả đã có trong list!!!");
            }
        }
        //sau khi coi xong nickName thì tới 2 thuộc tính kia
        this.inputInfor();//gọi để nhập hai thằng kia
    }
    //hàm showInfor
    public void showInfor(){
        String str = String.format("|%-30s|%-20s|%4d|", 
                                    name, nickName, yob);
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