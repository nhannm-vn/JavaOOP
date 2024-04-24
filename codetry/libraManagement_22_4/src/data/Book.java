package data;

import java.util.Scanner;


public class Book {
    //props riêng của Book
    private String bookName;
    private String createAt;
    private String nickName;
    
    //tạo phểu có full đối số

    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }
    
    //tạo phểu rỗng. Nếu vậy ta cần có thêm hàm inputInfor()

    public Book() {
    }
    //tạo thêm getter

    public String getBookName() {
        return bookName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getNickName() {
        return nickName;
    }
    
    //hàm inputInfor()
    
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên của cuốn sách: ");
        this.bookName = sc.nextLine();
        
        System.out.println("Nhập vào ngày tạo cuốn sách: ");
        this.createAt = sc.nextLine();
        
        System.out.println("Nhập vào nickname(bút danh) của cuốn sách: ");
        this.nickName = sc.nextLine();
        
    }
    
    //hàm in các thông tin ra
    public void showInfor(){
        System.out.printf("|%-30s|%-15s|%-15s|\n", bookName, createAt, nickName);
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