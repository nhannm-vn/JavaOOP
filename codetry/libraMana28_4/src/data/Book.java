package data;

import java.util.Scanner;

public class Book {
    //props riêng
    private String bookName;
    private String createAt;
    private String nickName;
    //tạo phểu có full đối số

    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }
    
    //phểu không có đối số thì cần thêm inputInfor()

    public Book() {
    }
    
    //method getter

    public String getBookName() {
        return bookName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getNickName() {
        return nickName;
    }
    //tạo method inputInfor()
    public void inputInfor(){//nhận vào full thông tin xài cho phểu không đối số
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên của cuốn sách: ");
        this.bookName = sc.nextLine();
        
        System.out.println("Nhập vào ngày viết sách: ");
        this.createAt = sc.nextLine();
        
        System.out.println("Nhập vào bút danh(nickName): ");
        this.nickName = sc.nextLine();
    
    }
    //method showInfor()
    public void showInfor(){
        String str = String.format("|%-30s|%-25s|%-20s"
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