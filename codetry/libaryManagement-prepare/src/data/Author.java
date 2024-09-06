package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //properties
    private String name;
    private String nickName;
    private int yob;
    
    //properties
    //full đối số 
    public Author(String name, String nickName, int yob) {
        this.name = name;
        this.nickName = nickName;
        this.yob = yob;
    }
    //phểu không có đối số 
    //khi xài cái này thì ta cần method inputInfor để nhập full thông tin của tg
    public Author() {
    }
    
    //phểu chỉ có đối số là nickName
    //dành cho trường hợp thêm mới một cuốn sách mà tác giả cuốn sách đó chưa có 
    //trong danh sách author thì ta sẽ thêm tác giả đó vào list. Mà vì thêm một cuốn
    //sách đã có nickName nên ta tận dụng lấy cái đó luôn nên mới có cái phểu này
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
    
    //hàm nhập vào thông tin tác giả
    //hàm nhập vào 2 thông tin là name và yob
    public void inputInfor(){//xài cho cái phểu đã có sẵn niickName nên không cần check trùng vì nếu xài này thì dã không có
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào name đi: ");
        this.name = sc.nextLine();
        //nhập vào yob đi
        System.out.println("Nhập vào yob đi: ");
        this.yob = Integer.parseInt(sc.nextLine());
    }
    
    //hàm nhập vào full thông tin và có check trùng trong danh sách, nếu trùng đã
    //có rồi thì bắt nhập lại, check bằng nickName
    //overload
    public void inputInfor(ArrayList<Author> auList){//nhận vào danh sách tác giả và kiểm tra có trùng không
        //xài chiêu overload kêu nhập dùm luôn
        inputInfor();//name, yob
        //kêu nó nhập vào nickName để kiểm tra
        Scanner sc = new Scanner(System.in);
        //kiểm tra trong mảng auList
        System.out.println("Nhập vào nickName đi: ");
        String key;
        boolean isFind;
        while(true){
            isFind = false;//giả sử lúc đầu không có
            key = sc.nextLine();
            //kiểm tra trong mảng coi có chưa
            for (Author item : auList) {
                if(item.getNickName().equals(key)){
                    isFind = true;
                }
            }
            if(!isFind){//nếu không có trùng thì làm
                this.nickName = key;
                return;
            }else{
                System.out.println("Tác giả đã có trong danh sách rồi!");
            }
        }
    }
    //hàm showInfor
    public void showInfor(){
        String str = String.format("%-20s|%-15s|%5d", name, nickName, yob);
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