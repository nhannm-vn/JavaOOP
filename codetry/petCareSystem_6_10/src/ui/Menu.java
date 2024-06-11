/*
user interface: giao diện người đùng
Menu: là một cái khuôn chuyên tạo ra các anh quản lí menu
có: danh sách các lựa chọn: option list
có: tên của menu: title
có: những hàm thao tác với option list
//thêm một option vào optionList
//hiển thị danh sách optionList
//hàm thu nhập lựa chọn của người dùng
 */
package ui;

import java.util.ArrayList;
import utils.Inputter;

public class Menu {
    //list cac option
    public static ArrayList<String> optionList = new ArrayList<>();
    public String title;
    
    //pheu

    public Menu(String title) {
        this.title = title;
    }
    
    //them mot option cho menu
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    
    //hien thi danh sach
    public void print(){
        System.out.println("_______" + title +"_______");
        int count = 1;
        for (String item : optionList) {
            System.out.println(count + "." + item);
            count++;
        }
    }
    
    //thu thap lua chon cua nguoi dung
    public int getChoice(){
        int choice = Inputter.getInt("Input your choice, plz: ", 
                                        "Your choice must between 1 and " + optionList.size(), 1, optionList.size());
        return choice;
    }
}
