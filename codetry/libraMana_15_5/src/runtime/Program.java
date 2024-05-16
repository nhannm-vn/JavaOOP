package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //muốn quản gì thì cũng cần có cái mảng để quản lí.
        //tạo ra một cái mảng để quản lí book
        //và một cái mảng để quản lí author
        ArrayList<Author> auList = new ArrayList<>();
        //mảng để quản lí các cuốn sách
        ArrayList<Book> boList = new ArrayList<>();
        
        //ta cần có một hàm initData() giúp nhập vào các thông tin sẵn để tiện test
        initData(auList, boList);
        
        //cấu trúc như bthg
        int choose;
        do{
            Scanner sc = new Scanner(System.in);
            //hàm showMenu()
            showMenu();
            System.out.println("Mời bạn nhập lựa chọn nha: ");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:{
                    System.out.println("1. thêm mới một cuốn sách");
                    Book newBook = new Book();
                    //gọi method nhập thông tin
                    newBook.inputInfor();
                    //kiểm tra xem bút danh của cuốn sách đã nằm trong List chưa
                    //nếu chưa có tác giả thì phải tạo mới. Nếu có rồi thì thôi
                    boolean isDup = false;//giả sử lúc đầu không có
                    for (Author item : auList) {
                        if(item.getNickName().equals(newBook.getNickName())){
                            isDup = true;//đã có trong list
                        }
                    }
                    if(!isDup){//nếu trong list chưa có
                        //ta xài cái phểu đã có nickname rồi
                        Author newAuthor = new Author(newBook.getNickName());
                        newAuthor.inputInfor();//nhập vào 2 thông tin thôi
                        //sau đó add tác giả đó vào trong List
                        auList.add(newAuthor);
                    }
                    //thêm cuốn sách vào trong list
                    boList.add(newBook);
                    break;
                }
                case 2:{
                    System.out.println("2. hiển thị thông tin sách ra màn hình");
                    if(boList.isEmpty()){
                        System.out.println("Không có cuốn sách nào trong List");
                        break;
                    }
                    System.out.println("Các cuốn sách trong list là: ");
                    for (Book book : boList) {
                        book.showInfor();
                    }
                    break;
                }
                case 3:{
                    System.out.println("3. thêm mới một tác giả");
                    //tác giả này phải full thông tin theo phểu không có đối số
                    //nếu tác giả này đã nằm trong list thì bắt nhập lại.
                    //đã ép nhạp lại bên class author
                    Author newAuthor = new Author();
                    newAuthor.inputInfor(auList);
                    //thêm vào trong list
                    auList.add(newAuthor);
                    break;
                }
                case 4:{
                    System.out.println("4. tìm kiếm sách theo bút danh");
                    System.out.println("Nhập vào bút danh của sách: ");
                    String key = sc.nextLine();
                    boolean isFind = false;
                    for (Book book : boList) {
                        if(book.getNickName().equals(key)){
                            isFind = true;
                            System.out.println("Cuốn sách đó là: ");
                            book.showInfor();
                        }
                    }
                    if(!isFind){//nếu không tìm thấy
                        System.out.println("Không tìm thấy sách!!!");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Xin chào và hẹn gặp lại!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong khoảng 1-5!!!");
                    break;
                }
            }
            
        }while(choose != 5);
        
    }
    
    public static void showMenu(){
        System.out.println("***Library Management Appliaction***");
        System.out.println("1.Nhập thông tin sách in ra màn hình");    
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
    }
    
    public static void initData(ArrayList<Author> auList,
                                ArrayList<Book> boList){
        //nạp vào các giá trị của tác giả
        auList.add(new Author("Ngoo Kiến Huy", "Huy Quan Hoa", 1997));
        auList.add(new Author("Nguyen Thuy Chi", "ChiPu", 1994));
        auList.add(new Author("Lê Mười Điệp", "UncleTen", 1999));
        
        boList.add(new Book("Kho Báu nơi biển sâu", "15-4-2024", "Huy Quan Hoa"));
        boList.add(new Book("Đừng làm mọi thứ phức tạp", "16-4-2024", "ChiPu"));
        boList.add(new Book("Dạy người giàu giả nghèo", "12-4-2024", "UncleTen"));
    }
    
}
//mối quan hệ has-in, không dựa trên mặt huyết thống
/*
tạo chương trình quản lý thư viện
gồm 2 class sau
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
Book
    bookName createAt nickName
    tạo có đối số và k có đồi số
    tạo getter anh setter
    tạo hàm input//nếu mà sách này có tác giả mà 
    có tên trong danh sách tác giả thì bỏ qua
    nếu tác giả của cuốn sách mà chưa có tồn tại trong ds
    thì thêm mới
program:
    menu
    1.Nhập thông tin sách in ra màn hình
    2.Hiển thị thông tin sách ra màn hình
    3.Nhập thông tin tác giả
    4.Tìm kiếm sách theo bút danh
    5.Thoát
*/