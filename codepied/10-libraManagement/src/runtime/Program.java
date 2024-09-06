package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //muốn quản lí cái gì cũng cần đưa về chung mảng rồi mới quản lí được
        //xài mảng co dãng ArrayList để quản lí Book và Author
        //mảng dùng để quản lí những thằng tác giả
        ArrayList<Author> auList = new ArrayList<>();
        
        //mảng dùng để quản lí những cuốn sách
        ArrayList<Book> boList = new ArrayList<>();
        
        //Ta cần nhập giá trị vào sẵn cho hai chiếc mảng này 
        //nhằm giúp thuận tiện cho việc test code
        
        //chuẩn bị một hàm showMenu()
        //tạo ra một Scanner
        Scanner sc = new Scanner(System.in);
        int choose;
        initData(auList, boList);
        do{
            //showMenu()
            //get choose
            //cấu trúc nhập lại
            showMenu();
            System.out.println("Vui lòng nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:{
                    System.out.println("Thêm mới một cuốn sách: ");
                    //tạo cuốn sách mới
                    Book newBook = new Book();
                    //hàm nhập thông tin cuốn sách vào
                    newBook.inputInfor();//nhập vào name, nickName, creatAt
                    //kiểm tra xem bút danh tác giả có nằm trong list chưa
                    //nếu chưa có thì ta thêm vào auList. Nếu có rồi thì thôi
                    //chỉ add cuốn sách thôi
                    boolean isDup = false;
                    //duplicate: trùng lập. Giả định lúc đầu chưa có để(false)
                    //kiểm tra trong list tác giả
                    for (Author author : auList) {
                        //nếu nickname cuốn sách mới đã có trong list thì
                        //isDup = true;
                        if(author.getNickname().equals(newBook.getNickName())){
                            isDup = true;
                        }
                    }
                    //nếu mà nickname của sách mới chưa có trong list
                    //thì add thông tin tác giả mới vào trong auList
                    if(!isDup){
                        //Vì trên kia nhập vào cuốn sách nickname đã nhập rồi
                        //nên ta tạo cuốn sách chỉ có nhập thêm 2 thông tin
                        Author newAuthor = new Author(newBook.getNickName());
                        //nhạp thông tin vào cho tác giả
                        newAuthor.inputInfor();//nhập vào name và yob
                        //thêm tác giả đó vào list
                        auList.add(newAuthor);
                    }
                    
                    //dù có thêm tác giả mới vào do trong list có hay chưa
                    //ta cũng cần thêm cuốn sách mới vào boList
                    boList.add(newBook);
                    break;
                }
                case 2:{
                    //in thông tin sách ra màn hình
                    //trước khi in thì kiểm tra xem trong danh sách có sách không
                    //giả định lúc đầu không tìm thấy
                    boolean isFind = false;
                    for (Book book : boList) {
                        book.showInfor();
                        //nếu in ra được cuốn sách nào là true, không thì false
                        isFind = true;
                    }
                    if(!isFind){//trường hợp không có sách
                        System.out.println("Không có sách trong danh sách!!!");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Thêm thông tin tác giả");
                    //nếu trong danh sách đã có tác giả thì thôi không thêm trùng
                    //mình đã chuẩn bị nó bên class Author
                    Author newAuthor = new Author();
                    //nhập vào thông tin
                    newAuthor.inputInfor(auList);//hàm này nhập thông tin và
                    //kiểm tra xem có trong list không. Nếu chưa có thì nhập full
                    //có rồi thì thôi
                    //sau khi nhập rồi thì thêm thông tin vào list
                    auList.add(newAuthor);
                    
                    break;
                }
                case 4:{
                    System.out.println("Tìm kiếm sách dựa theo bút danh: ");
                    //nhập vào bút danh
                    System.out.println("Nhập vào bút danh(nickname) cần tìm: ");
                    String key = sc.nextLine();
                    
                    //kiểm tra xem trong list book cuốn nào có bút danh vậy thì in ra
                    //không có thì báo không
                    boolean isFind = false;//giả định lúc đầu không có
                    for (Book book : boList) {
                        if(book.getNickName().equals(key)){
                            book.showInfor();
                            isFind = true;
                        }
                    }
                    if(!isFind){
                        System.out.println("Không tìm thấy!!!");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Xin chào và hẹn gặp lại ^^");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong 1-5!");
                    break;
                }
            }
        
        }while(choose != 5);//nếu choose != 5 thì lặp lại 
        
        
    }
    public static void showMenu(){
        System.out.println("***Library Management System***");
        System.out.println("1.Nhập thông tin sách");
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
