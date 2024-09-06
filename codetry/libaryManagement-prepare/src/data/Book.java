package data;

import java.util.Scanner;

public class Book {
    //properties
    private String bookName;
    private String createAt;
    private String nickName;
    
    //constructer

    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }
    //không có đối số 

    public Book() {
    }
    
    //tạo getter 

    public String getBookName() {
        return bookName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getNickName() {
        return nickName;
    }
    
    //tạo method inputInfor(). Nhập vào full thông tin
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        //nhập vào bookName
        System.out.println("Nhập vào tên của cuốn sách: ");
        this.bookName = sc.nextLine();
        
        //nhập vào createAt
        System.out.println("Nhập vào ngày tạo: ");
        this.createAt = sc.nextLine();
        
        //nhập vào nickName
        System.out.println("Nhập vào nickname(bút danh): ");
        this.nickName = sc.nextLine();
        
    }
    //method in ra thông tin của cuốn sách
    
    public void showInfor(){
        String str = String.format("%-30s|%-15s|%-20s", bookName, createAt, nickName);
        System.out.println(str);
    }
    
    
}
/*
Book
    bookName createAt nickName
    tạo có đối số và k có đồi số
    tạo getter anh setter
    tạo hàm input//nếu mà sách này có tác giả mà 
    có tên trong danh sách tác giả thì bỏ qua
    nếu tác giả của cuốn sách mà chưa có tồn tại trong ds
    thì thêm mới
*/
