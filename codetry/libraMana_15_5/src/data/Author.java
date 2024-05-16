package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //props
    private String name;
    private String nickName;
    private int yob;
    
    //constructor
    //phểu có full đối số. Khi ta truyền vào giá trị sẽ đúc ra được đối tượng

    public Author(String name, String nickName, int yob) {
        this.name = name;
        this.nickName = nickName;
        this.yob = yob;
    }
    //phểu chỉ có nhận vào nickName. Vì khi ta tạo mới một cuốn sách thì phải thêm 
    //nickName cho cuốn sách. nếu cuốn sách chưa có tác giả thì phải thêm mới tác
    //giả. Nhưng vì đã thêm nickName bên cuốn sách nên chỉ cần thêm name và yob thôi
    public Author(String nickName) {
        this.nickName = nickName;
    }
    //phểu không có đối số. Để thêm mới một tác giả thì ta cần một hàm inputInfor()
    //nhận vào full thông tin của tác giả. Tuy nhiên khi ta nhập vào ta cần check
    //coi tác giả có trong List chưa nếu có rồi thì bắt nhập lại

    public Author() {
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
    
    //hàm nhập thông tin tác giả
    public void inputInfor(){//nhập vào 2 thông tin name và yob thôi. Xài cho phểu 1 đối số
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên tác giả: ");
        this.name = sc.nextLine();
        System.out.println("Nhập vào năm sinh tác giả: ");
        this.yob = Integer.parseInt(sc.nextLine());
    }
    //hàm nhập full thông tin tác giả. Nhưng nếu tác giả đã tồn tại trong list thì
    //ép nhập lại. Check bằng nickName
    //Overrload
    public void inputInfor(ArrayList<Author> auList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào nickName của tác giả: ");
        while(true){
           String inputNickName = sc.nextLine();
           boolean isDup = false;
            for (Author item : auList) {
                if(item.nickName.equals(inputNickName)){
                    isDup = true;
                }
            }
            if(isDup){//nếu có trong list thì báo là đã trùng
                System.out.println("Tác giả đã có trong List!!!");
            }else{
                this.nickName = inputNickName;
                break;
            }
        }
        //sau khi check coi tác giả có trong List không thì ta cho nhập tới 2 method còn lại
        inputInfor();
    }
    //hàm in ra thông tin
    public void showInfor(){
        String str = String.format("%-30s|%-25s|%4d"
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