package data;

//tạo cái khuôn chuyên dùng để đúc ra những cuốn sách(Book)

import java.util.Scanner;

public class Book {
    //properties chỉ có sách có
    private String bookName;
    private String createAt;
    private String nickName;
    
    //tạo constructor có full đối số

    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }
    
    //tạo constructor không có đối số. Nếu không có đối số thì phải có thêm 
    //hàm inputInfor(). Để nhập thông tin
    //Overload
    public Book() {
    }
    
    //tạo ra getter và không có setter

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
        //nhớ có \n để xuống hàng không thì sẽ bug
        System.out.printf("|-30%s|-25%s|-15%s\n", bookName, createAt, nickName);
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
