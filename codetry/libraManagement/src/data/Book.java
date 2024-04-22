package data;

import java.util.Scanner;

public class Book {
    //book có các thuộc tính riêng
    private String bookName;
    private String creatAt;
    private String nickName;
    
    //constructor
    //phểu có full đối số

    public Book(String bookName, String creatAt, String nickName) {
        this.bookName = bookName;
        this.creatAt = creatAt;
        this.nickName = nickName;
    }
    
    //tạo phểu không có đối số
    //Overload
    public Book() {
    }
    
    //tạo getter
    
    public String getBookName() {
        return bookName;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public String getNickName() {
        return nickName;
    }
    
    //hàm nhập giá trị
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên của sách: ");
        this.bookName = sc.nextLine();
        System.out.println("Nhập ngày tạo: ");
        this.creatAt = sc.nextLine();
        System.out.println("Nhập vào nickname(bút danh) của tác giả đã viết sách: ");
        this.nickName = sc.nextLine();
        
    }
    //hàm in ra thông tin
    public void showInfor(){
        //phải nhớ xuống hàng chứ k bug
        System.out.printf("|%-30s|%-25s|%-15s\n", bookName, creatAt, nickName);
    }
}
/*
Book
    bookName createAt nickName
    tạo có đối số và k có đồi số
    tạo getter and setter
    tạo hàm input//nếu mà sách này có tác giả mà 
    có tên trong danh sách tác giả thì bỏ qua
    nếu tác giả của cuốn sách mà chưa có tồn tại trong ds
    thì thêm mới
*/