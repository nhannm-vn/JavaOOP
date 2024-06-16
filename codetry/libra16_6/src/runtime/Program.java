package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //mảng quản lí các tác giả:
        ArrayList<Author> auList = new ArrayList<>();
        //mảng quản lí các cuốn sách
        ArrayList<Book> boList = new ArrayList<>();
        initData(auList, boList);
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            showMenu();
            System.out.println("Mời bạn nhập vào lựa chọn nhé: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    Book newBook = new Book();
                    //xài hàm nhập thông tin
                    newBook.inputInfor();
                    //kiểm tra xem trong danh sách tác giả đã có tác giả của 
                    //cuốn sách mới chưa. Nếu chưa thì thêm mới tác giả rồi add vào list
                    //nếu có rồi thì bỏ qua chỉ thêm mới cuốn sách vào list thôi
                    boolean isDup = false;
                    for (Book book : boList) {
                        if(book.getNickName().equals(newBook.getNickName())){
                            isDup = true;
                        }
                    }
                    if(!isDup){//nếu chưa có tên trong danh sách tác giả thì làm
                        Author newAuthor = new Author(newBook.getNickName());
                        newAuthor.inputInfor();//nhập vào 2 thông tin thôi
                        auList.add(newAuthor);
                    }
                    boList.add(newBook);
                    System.out.println("Thêm mới một cuốn sách thành công!");
                    break;
                }
                case 2:{
                    if(boList.isEmpty()){
                        System.out.println("Danh sách trống!!!");
                        break;
                    }
                    for (Book item : boList) {
                        item.showInfor();
                    }
                    break;
                }
                case 3:{
                    Author newAuthor = new Author();
                    newAuthor.inputInfor(auList);
                    auList.add(newAuthor);
                    System.out.println("Thêm mới một tác giả thành công!");
                    break;
                }
                case 4:{
                    String keyNickName;
                    System.out.println("Nhập vào bút danh của cuốn sách cần tìm: ");
                    keyNickName = sc.nextLine();
                    boolean isFind = false;
                    for (Book book : boList) {
                        if(book.getNickName().equals(keyNickName)){
                            isFind = true;//tìm thấy
                            System.out.println("Cuốn sách cần tìm nè: ");
                            book.showInfor();
                        }
                    }
                    if(!isFind){//nếu không tìm thấy
                        System.out.println("Không tìm thấy cuốn sách nào!");
                    }   
                    break;
                }
                case 5:{
                    System.out.println("Xin chào và hẹn gặp lại!");
                    return;
                }
                default:{
                    System.err.println("Lựa chọn phải nằm trong khoảng từ 1 đến 5 cơ!!!");
                }
            }
        }
    }
    public static void initData(ArrayList<Author>auList, 
            ArrayList<Book> boList){//nhập giá trị cho hai cái mảng để dễ test code
        //nạp giá trị vào danh sách tác giả
        auList.add(new Author("Ngoo Kien Huy", "Huy Quan Hoa", 1997));
        auList.add(new Author("Nguyen Thuy Chi", "ChiPu", 1994));
        auList.add(new Author("Le Muoi Diep", "UncleTen", 1999));
        
        //nạp vào vài cuốn sách
        boList.add(new Book("Kho Báu nơi biển sâu", "15-4-2024", "Huy Quan Hoa"));
        boList.add(new Book("Đừng làm mọi thứ phức tạp", "16-4-2024", "ChiPu"));
        boList.add(new Book("Dạy người giàu giả nghèo", "12-4-2024", "UncleTen"));
    }
    public static void showMenu(){
        System.out.println("~_~***Library Management System***~_~");
        System.out.println("1.Thêm mới một cuốn sách");
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
        System.out.println("______________________________________");
    }
}
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
