package data;

import java.util.Scanner;

public class Book {
    //props
    private String bookName;
    private String createAt;
    private String nickName;
    //contructor
    Scanner sc = new Scanner(System.in);
    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }
    
    //constructor rong

    public Book() {
    }
    
    //getter

    public String getBookName() {
        return bookName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getNickName() {
        return nickName;
    }
    //method inputInfor()
    public void inputInfor(){
        System.out.println("Nhap vao ten cua quyen sach: ");
        this.bookName = sc.nextLine();
        System.out.println("Nhap vao ngay sang tac: ");
        this.createAt = sc.nextLine();
        System.out.println("Nhap vao nickname(butdanh) tac gia: ");
        this.nickName = sc.nextLine();
    }
    //method showInfor()
    public void showInfor(){
        String str = String.format("%25s|%20s|%20s", bookName, createAt, nickName);
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