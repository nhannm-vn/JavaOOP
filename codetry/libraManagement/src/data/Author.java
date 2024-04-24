package data;

import java.util.ArrayList;
import java.util.Scanner;


public class Author {
    //tạo ra các props của Author
    private String name;
    private String nickname;
    private int yob;
    //tạo constructor cái phểu(3 phểu)
    //cái phểu rỗng(khi muốn người dùng nhập vào) + đi kèm hàm inputInfor()
    //phểu rỗng + inputInfor()(auList): nhập name, nickname, yob
    public Author() {
    }
    
    //phểu full thông tin dùng để tạo đối tượng khi có full thông tin

    public Author(String name, String nickname, int yob) {
        this.name = name;
        this.nickname = nickname;
        this.yob = yob;
    }
    
    //phểu chỉ có nickname
    //dùng để tạo ra đối tượng đã có sắn nickname rồi. Thiếu name và yob
    public Author(String nickname) {
        this.nickname = nickname;
    }
    
    //tạo getter

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getYob() {
        return yob;
    }
    
    /*
    tạo hàm nhập thông tin tác giả
    nhưng nếu tác giả đã tồn tại trong danh sách thì k cho
    ép nhập lại
    */
    
    //Tạo hàm nhập thông tin
    //hàm inputInfor(): hàm nhập thông tin cho tác giả: name + yob
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên của tác giả: ");
        this.name = sc.nextLine();
        
        System.out.println("Nhập năm sinh của tác giả: ");
        this.yob =  Integer.parseInt(sc.nextLine());//ép kiểu tránh buffer
        
    }
    //Overload
    public void inputInfor(ArrayList<Author> auList){//nhập nickname(cấm trùng), name, yob
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập nickname(bút danh) cho tác giả: ");
        while(true){
            String inputNickname = sc.nextLine();//nhập nickname của tác giả
            //sau đó hỏi trong danh sách tác giả có thằng nào trùng nickname không
            boolean isDup =  false;
            //Duplicate: trùng lập
            for (Author author : auList) {
                if(author.getNickname().equals(inputNickname)) isDup = true;
            }
            if(isDup){//nếu đã có trong danh sách
                System.out.println("Nickname đã có người sử dụng!");
            }else{//nếu chưa có nickname đó thì gán xong rồi dừng
                this.nickname = inputNickname;
                break;
            }
        }
        //nhập name và yob
        //gọi lại hàm inputInfor() trên xài lại
        this.inputInfor();
        
    }
    //hàm showInfor()
    public void showInfor(){
        System.out.printf("|%-30s|%-30s|%4d\n",  name, nickname, yob);
    }
    
}
/*
Author
    name nickname yob;
    tạo phểu hàm không đối số
    tạo phểu có đối số 
    tạo phểu có đối số là nickname
    tạo getter không tạo setter
    tạo hàm nhập thông tin tác giả
    nhưng nếu tác giả đã tồn tại trong danh sách thì k cho
    ép nhập lại
    tạo hàm showInfor
*/