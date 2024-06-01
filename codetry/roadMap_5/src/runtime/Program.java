package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //tao cai mang quan li tac gia va book
        ArrayList<Author> auList = new ArrayList<>();
        ArrayList<Book> boList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //ham truyen thong tin vao
        initData(auList, boList);
        int choice;
        do{
            //showMenu
            showMenu();
            System.out.println("Mời bạn nhập vào lựa chọn nhé: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    Book nBook = new Book();
                    nBook.inputInfor();
                    //neu tac gia cuon sach chua co trong list thì thêm mới tác giả
                    boolean isFind = false;
                    for (Author author : auList) {
                        if(author.getNickName().equals(nBook.getNickName())){
                            isFind = true;
                        }
                    }
                    if(!isFind){//neu trong list chua co tac gia cua cuon sach moi
                        Author nAuthor = new Author(nBook.getNickName());
                        nAuthor.inputInfor();
                        //them tac gia vao trong list
                        auList.add(nAuthor);
                    }
                    //dù có thêm mới tác giả vào list hay không thì cũng phải thêm sách vào list
                        boList.add(nBook);
                    
                    System.out.println("Thêm mới một cuốn sách thành công!");
                    break;
                }
                case 2:{
                    if(boList.isEmpty()){
                        System.out.println("Không có cuốn sách nào trong list!");
                    }else{
                        System.out.println("Các quyển sách trong list là: ");
                        for (Book book : boList) {
                            book.showInfor();
                        }
                    }
                    break;
                }
                case 3:{
                    Author nAuthor = new Author();
                    nAuthor.inputInfor(auList);//them day du thong tin tac gia
                    auList.add(nAuthor);
                    break;
                }
                case 4:{
                    System.out.println("Nhập bút danh(nickname) của cuốn sách mà bạn muốn tìm: ");
                    String keyNickName = sc.nextLine();
                    boolean isFind = false;
                    for (Book book : boList) {
                        if(book.getNickName().equals(keyNickName)){
                            isFind = true;
                            System.out.println("Các cuốn sách muốn tìm là: ");
                            book.showInfor();
                        }
                    }
                    if(!isFind){
                        System.out.println("Không có cuốn sách nào được tìm thấy");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Xin chào và hẹn gặp lại!!!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong koangr từ 1 đến 5");
                    break;
                }
            }
        }while(choice != 5);
        
    }
    public static void showMenu(){
        System.out.println("***Library Management System***");
        System.out.println("1.Nhập thông tin sách in ra màn hình");
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
        
    }
    public static void initData(ArrayList<Author> auList, ArrayList<Book> boList){
        //nạp giá trị vào danh sách tác giả
        auList.add(new Author("Ngoo Kien Huy", "Huy Quan Hoa", 1997));
        auList.add(new Author("Nguyen Thuy Chi", "ChiPu", 1994));
        auList.add(new Author("Le Muoi Diep", "UncleTen", 1999));
        
        //nạp vào vài cuốn sách
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
