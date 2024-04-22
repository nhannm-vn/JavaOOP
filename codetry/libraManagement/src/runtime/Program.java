package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //quản lí thư viện:
        //+quản lí tác giả của những cuốn sách
        //+những cuốn sách
        //==>cần hai cái mảng để quản lí
        ArrayList<Author> auList = new ArrayList<>();
        //mảng quản lí những tác giả <tác giả>
        ArrayList<Book> boList = new ArrayList<>();
        //mảng quản lí những cuốn sách <cuốn sách>
        
        //khi mới tạo ra hai mảng chưa có giá trị gì hết
        //nếu không nạp vào thì test code sẽ mệt
        
        initData(auList, boList);//nạp giá trị vào hai mảng này
        
        //tạo choose để chọn và tạo menu
        int choose;
        Scanner sc = new Scanner(System.in);
        
        do{
            //showMenu()
            //getChoose
            //thực thi chức năng
            showMenu();
            System.out.println("Vui lòng nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());//tránh buffer
            switch(choose){
                case 1:{
                    System.out.println("Thêm mới một cuốn sách: ");
                    Book newBook = new Book();//tạo ra cuốn sách bằng phểu rỗng
                    newBook.inputInfor();//nhập bookName, createAt, nickName
                    
                    //Tìm xem có tác giả nào có nickname giống sách không
                    boolean isDup = false;
                    //tìm trong danh sách tác giả 
                    for (Author author : auList) {
                        //tìm xem có ai đã viết cuốn sách này hay chưa
                        if(author.getNickname().equals(newBook.getNickName())){
                            isDup = true;
                        }
                    }
                    if(!isDup){//nếu không có thì phải tạo mới tác giả
                        //lý do không dùng hàm inputInfor(author) vì:
                        //sẽ nhập thêm nickname lần nữa là bị trùng
                        //KO LẼ NHẬP NICKNAME HAI LẦN!!!
                        
                        //phải thiết kế sao cho nhập nickname 1 lần
                        //sử dụng phểu tạo tác giả bằng phểu có sẵn nickname
                        Author newAuthor = new Author(newBook.getNickName());
                        //ta sẽ truyền vào nickname mới nhập từ cuốn sách mới
                        newAuthor.inputInfor();//nhập thêm name, yob thôi!
                        //sau khi nhập giá trị hết rồi thì mình add vào list
                        auList.add(newAuthor);
                    }
                    //sau khi tạo xong sách thì add vào list book thôi bé
                    boList.add(newBook);
                    
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị thông tin các cuốn sách");
                    //check xem có sách trong boList không
                    boolean isFind = false;
                    for (Book book : boList) {
                        book.showInfor();
                        isFind = true;
                    }
                    if(!isFind){
                        System.out.println("Không có cuốn sách nào!");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Thêm mới một tác giả mới");
                    //lúc này mình phải xài cái phểu tạo mới mà có check trong 
                    //danh sách để check và input đầy đủ thông tin
                    //nếu tác giả đã tồn tại thì ép nhập lại
                    Author newAuthor = new Author();
                    newAuthor.inputInfor(auList);//nhập đầy đủ các thông tin
                    //check không trùng rồi thì add vào list tác giả
                    auList.add(newAuthor);
                    
                    break;
                }
                case 4:{
                    System.out.println("In ra các cuốn sách dựa trên nickname");
                    System.out.println("Nhập vào nickname của tác giả cuốn sách: ");
                    String key = sc.nextLine();
                    
                    //check nickname có trong ds ko
                    boolean isFind = false;
                    for (Book book : boList) {
                        if(book.getNickName().equals(key)){
                            book.showInfor();
                            isFind = true;
                        }
                    }
                    
                    //nếu không tìm thấy thì báo
                    if(!isFind){
                        System.out.println("Không tìm thấy cuốn sách nào!");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Cảm ơn và hẹn gặp lại!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong 1-5!!!");
                    break;
                }
            }
            
        }while(choose != 5);//còn khác 5 là còn lập. Nhập 5 là dừng hẳn
        
    }
    //nhận vào hai mảng rồi nạp giá trị cho nó
    public static void initData(ArrayList<Author> auList, 
                                ArrayList<Book> boList){
        //nạp giá trị vào danh sách tác giả
        //vì các chức năng dựa vào nickname nên là không dấu
        auList.add(new Author("Ngô Kiến Huy", "Huy Quan Hoa", 1997));
        auList.add(new Author("Nguyễn Thùy Chi", "ChiPu", 1994));
        auList.add(new Author("Lê Mười Điệp", "UncleTen", 1999));
        
        //nạp vào vài cuốn sách
        boList.add(new Book("Kho báu nơi biển sâu", "15-4-2024", "Huy Quan Hoa"));
        boList.add(new Book("Đừng làm mọi thứ phức tạp", "16-4-2024", "ChiPu"));
        boList.add(new Book("Dạy người giàu giả nghèo", "12-4-2024", "UncleTen"));
    }
    //hàm showMenu()
    public static void showMenu(){
        System.out.println("***Library Management System***");
        System.out.println("1.Nhập thông tin sách");
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
