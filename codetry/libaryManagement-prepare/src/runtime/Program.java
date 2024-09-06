package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //muốn quản lí gì thì cần có danh sách của thằng đó
        //tạo ra 2 cái danh sách quản lí lần lượt author và book
        //danh sách quản lí author
        ArrayList<Author> auList = new ArrayList<>();
        //danh sách quản lí book
        ArrayList<Book> booList = new ArrayList<>();
        initData(auList, booList);//thêm vô để dễ test code
        //scanner
        Scanner sc = new Scanner(System.in);
        //biến để lựa chọn
        int choose = 0;
        do {       
            //đưa menu cho người ta lựa chọn
            showMenu();
            System.out.println("Mời bạn nhập vào lựa chọn nhé: ");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:{
                    //thêm mới một cuốn sách
                    Book newBook = new Book();
                    //nhờ thằng người dùng nhập các thồng tin dùm đi
                    newBook.inputInfor();
                    //kiểm tra xem nickName của tác giả đã có trong auList chưa
                    //nếu chưa có thì tạo ông tác giả đó và thêm vào list
                    boolean isFind = false;//giả sử lúc đầu chưa có
                    for (Author item : auList) {
                        if(item.getNickName().equals(newBook.getNickName())){
                            isFind = true;
                            break;
                        }
                    }
                    if(!isFind){//chưa có thì thêm vô
                        //tạo mới tác giả bằng cái phểu nhận nickname
                        Author newAuthor = new Author(newBook.getNickName());
                        //nhập 2 thông tin còn lại cho nó
                        newAuthor.inputInfor();
                        //thêm nó vào list
                        auList.add(newAuthor);
                    }
                    //sau khi thêm tác giả rồi thì phải thêm cuốn sách vô list chứ
                    booList.add(newBook);
                    break;
                }
                case 2:{
                    //hiển thông tin các cuốn sách ra màn hình
                    if(booList.isEmpty()){
                        System.out.println("Danh sách các cuốn sách trống!");
                    }else{
                        System.out.println("Danh sách những cuốn sách nè: ");
                        for (Book book : booList) {
                            book.showInfor();
                        }
                    }
                    break;
                }
                case 3:{
                    //thêm mới một tác giả vào trong list
                    Author newAuthor = new Author();
                    //nhờ người dùng nhập vào thông tin tác giả
                    //nó có nhận vào auList để kiểm tra luôn
                    newAuthor.inputInfor(auList);
                    //thêm mới tác giả vào trong list
                    auList.add(newAuthor);
                    break;
                }
                case 4:{
                    //tìm kiếm sách dựa trên nickName
                    System.out.println("Nhập vào nickName(bút danh) cần tìm: ");
                    String key = sc.nextLine();
                    boolean isFind = false;
                    for (Book item : booList) {
                        if(item.getNickName().equals(key)){
                            isFind = true;
                            item.showInfor();
                        }
                    }
                    if(!isFind){
                        System.out.println("Không tìm thấy!!!");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Xin chào và hẹn gặp lại nhé!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong khoảng 1 đến 5 nhé!");
                    break;
                }
            }
        } while (choose != 5);
        
    } 
    //hàm showMenu
    public static void showMenu(){
        System.out.println("***Library Management System***");
        System.out.println("1.Thêm mới một cuốn sách");
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
    }
    //nhận vào hai cái mảng và nhập giá trị cho nó
    public static void initData(ArrayList<Author> auList, 
                                ArrayList<Book> boList){
        //nạp các tác giả vào. Vì nickname tìm kiếm theo nó. Nên là để không dấu
        auList.add(new Author("Ngô Kiến Huy", "Huy Quan Hoa", 1997));
        auList.add(new Author("Nguyễn Thùy Chi", "ChiPu", 1994));
        auList.add(new Author("Lê Mười Điệp", "UncleTen", 1999));
        //nạp vào các cuốn sách
        boList.add(new Book("Kho báu nơi biển sâu", "15-4-2024", "Huy Quan Hoa"));
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
