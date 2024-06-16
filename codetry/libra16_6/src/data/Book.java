package data;

import java.util.Scanner;

public class Book {
    //prop
    private String bookName;
    private String createAt;
    private String nickName;
    
    //phểu có đối số

    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }
    
    //phểu không có đối số

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
    //inputInfor: nhập full thông tin của của cuốn sách
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên của cuốn sách: ");
        this.bookName = sc.nextLine();
        System.out.println("Nhập vào ngày tháng xuất bản: ");
        this.createAt = sc.nextLine();
        System.out.println("Nhập vào bút danh(nickName) của tác giả: ");
        this.nickName = sc.nextLine();
    }
    
    public void showInfor(){
        String str = String.format("%-30s|%-20s|%-10s"
                                , bookName, createAt, nickName);
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