package runtime;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        //muốn quản lí tác giả hay sách thì đều cần hai cái mảng chung
        ArrayList<Author> auList = new ArrayList<>();
        //quản lí sách
        ArrayList<Book> boList = new ArrayList<>();
        
        //ta tạo hàm initData để nạp sẵn giá trị khi test code
        //hàm sẽ nạp giá trị vào sẵn cho hai mảng
        initData(auList, boList);//nạp giá trị vào sẵn
        
        //tạo choose và method showMenu
        Scanner sc = new Scanner(System.in);
        int choose;
        
        do{
            showMenu();
            System.out.println("Mời bạn nhập lựa chọn nha: ");
            choose = Integer.parseInt(sc.nextLine());
            
            switch(choose){
                case 1:{
                    System.out.println("Thêm mới một cuốn sách: ");
                    //thêm mới một cuốn sách nếu sách chưa có tác giả thì thêm mới author
                    //nếu trong danh sách đã có tác giả rồi thì thôi
                    Book newBook = new Book();
                    newBook.inputInfor();//nhập vào thông tin sách
                    //kiểm tra xem trong danh sách tác giả đã có chưa
                    boolean isDup = false;
                    for (Author author : auList) {
                        if(author.getNickName().equals(newBook.getNickName())){
                            isDup = true;
                        }
                    }
                    //nếu chưa có bắt nhập thêm 2 thông tin còn lại thông
                    //qua phểu nhận vào sẵn nickName. Nếu có rồi thì thôi
                    if(!isDup){
                        Author newAuthor = new Author(newBook.getNickName());//nhận vào sẵn nickname từ cuốn sách
                        newAuthor.inputInfor();//nhập vào 2 thông tin thôi
                        auList.add(newAuthor);//thêm tác giả đó và trong list
                    }
                    //thêm cuốn sách vào list
                    boList.add(newBook);
                    break;
                }
                case 2:{
                    System.out.println("Kiển thị thông tin sách ra màn hình: ");
                    if(boList.isEmpty()){
                        System.out.println("Không có cuốn sách nào!!!");
                    }else{
                        System.out.println("Các cuốn sách trong list ne: ");
                        for (Book book : boList) {
                            book.showInfor();
                        }
                    }
                    
                    break;
                }
                case 3:{
                    System.out.println("Thêm mới một tác giả: ");
                    //nếu trùng rồi thì bắt nhập lại, đã ép bên class author
                    Author newAuthor = new Author();
                    //nhận vào full thông tin và check List
                    newAuthor.inputInfor(auList);
                    //thêm tác giả vào list
                    auList.add(newAuthor);
                    break;
                }
                case 4:{
                    System.out.println("Tìm sách dựa vào bút danh(nickname): ");
                    String key = sc.nextLine();
                    
                    //tìm trong list coi có sách không
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
                    System.err.println("Lựa chọn phải nằm trong khoảng 1-5!!!");
                    break;
                }
            }
            
        }while(choose != 5);
        
    }
    public static void initData(ArrayList<Author> auList,
                         ArrayList<Book> boList){
        //nạp giá trị vào danh sách tác giả
        //tên có thể viết có dấu vì không có đụng gì hết
        //còn nickName phải viết thường
        auList.add(new Author("Ngô Kiến Huy", "Huy Quan Hoa", 1997));
        auList.add(new Author("Nguyễn Thùy Chi", "ChiPu", 1994));
        auList.add(new Author("Lê Mười Điệp", "UncleTen", 1999));
        
        //nạp thông tin cho danh sách Book
        boList.add(new Book("Kho báu nơi biển sâu", "15-4-2024", "Huy Quan Hoa"));
        boList.add(new Book("Đừng làm mọi thứ phức tạp", "16-4-2022", "ChiPu"));
        boList.add(new Book("Dạy người giàu giả nghèo", "12-4-2024", "UncleTen"));
    }
    public static void showMenu(){
        System.out.println("***Library Management System Application***");
        System.out.println("1.Nhập thông tin sách in ra màn hình");
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
        
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