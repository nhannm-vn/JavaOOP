package data;

import java.util.Scanner;

public class Book {
    //props
    private String bookName;
    private String createAt;
    private String nickName;
    //constructor full đối số

    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }
    
    //constructor không đối số

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
    
    //vì có phểu rỗng nên ta cần method nhập thông tin
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên sách: ");
        this.bookName = sc.nextLine();
        System.out.println("Nhập vào ngày xuất bản: ");
        this.createAt = sc.nextLine();
        System.out.println("Nhập vào bút danh: ");
        this.nickName = sc.nextLine();
    }
    
    //vì có phểu rỗng nên ta cần method thêm thông tin
    public void showInfor(){
        String str = String.format("%-40s|%-30s|%-25s"
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