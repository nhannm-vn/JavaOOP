package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        //muốn quản lí bất cứ thứ gì cũng cần mảng để bỏ vào quảng lí chung
        //mảng để quản lí các tác giả
        ArrayList<Author> auList = new ArrayList<>();
        //mảng để quản lí các cuốn sách
        ArrayList<Book> boList = new ArrayList<>();
        
        //ta tạo hàm nạp sẵn cho danh sách các cuốn sách và tác giả để
        //thuận lợi cho việc test code
        initData(auList, boList);
        
        //tạo hàm showMenu()
        
        int choose;
        Scanner sc = new Scanner(System.in);
        
        do{
            showMenu();
            System.out.println("Mời bạn nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());//tránh buffer
            
            switch(choose){
                case 1:{
                    System.out.println("Thêm thông tin một cuốn sách mới: ");
                    Book newBook = new Book();
                    //nhập thông tin cuốn sách
                    newBook.inputInfor();
                    
                    //kiểm tra xem nickname của cuốn sách có trong auList chưa
                    //nếu chưa thì thêm tác giả đó vào list
                    boolean isDup = false;//giả sử lúc đầu không có trong list
                    
                    for (Author author : auList) {
                        if(author.getNickName().equals(newBook.getNickName())){
                            isDup = true;
                        }
                    }
                    if(!isDup){
                        Author newAuthor = new Author(newBook.getNickName());
                        newAuthor.inputInfor();//nhập vào hai thuộc tính thôi
                        auList.add(newAuthor);
                    }
                    boList.add(newBook);//sau khi xét tác giả rồi thì add cuốn sách vào
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị thông tin của sách: ");
                    boolean isFind = false;
                    for (Book book : boList) {
                        book.showInfor();
                        isFind = true;
                    }
                    if(!isFind){//nếu như trong list không có cuốn nào
                        System.out.println("Không có cuốn sách nào!!!");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Nhập thông tin tác giả: ");
                    Author newAuthor = new Author();
                    //xài phểu rỗng để bắt nhập vào rồi check coi có chưa
                    //nếu chưa có trong list thì bắt nhập lại
                    
                    newAuthor.inputInfor(auList);
                    //tạo xong thì add vào trong list
                    auList.add(newAuthor);
                    break;
                }
                case 4:{
                    System.out.println("Tìm kiếm sách theo bút danh: ");
                    System.out.println("Nhập vào bút danh cần tìm: ");
                    String key = sc.nextLine();
                    boolean isFind = false;
                    for (Book book : boList) {
                        if(book.getNickName().equals(key)){
                            isFind = true;
                            System.out.println("Cuốn sách đó là: ");
                            book.showInfor();
                        }
                    }
                    if(!isFind){
                        System.out.println("Không tìm thấy!!!");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Hẹn gặp lại nhé!!!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong khoảng 1-5");
                    break;
                }
            }
        }while(choose != 5);
    }
    //hàm showMenu()
    public static void showMenu(){
        System.out.println("***Library Management System***");
        System.out.println("1.Nhập thông tin sách in ra màn hình");
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
        
    }
    
    //nhận vào hai list rồi truyền giá trị vào cho nó
    public static void initData(ArrayList <Author> auList, 
                                ArrayList <Book> boList){
        auList.add(new Author("Ngô Kiến Huy", "Huy Quan Hoa", 1997));
        auList.add(new Author("Nguyễn Thùy Chi", "ChiPu", 1994));
        auList.add(new Author("Lê Mười Điệp", "UncleTen", 1999));
        
        //nạp vào vài cuốn sách
        boList.add(new Book("Kho báu nơi biển sâu", "15-4-2024", "Huy Quan Hoa"));
        boList.add(new Book("Đừng làm mọi thứ phức tạp", "16-4-2024", "ChiPu"));
        boList.add(new Book("Dạy người giàu giả nghèo", "12-4-2024", "UncleTen"));
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
