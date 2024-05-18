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
    //mảng lưu các lựa chọn
    public static ArrayList<String> optionList = new ArrayList<>();
    public String title;//tên của menu
    //constructor

    public Menu(String title) {
        this.title = title;
    }
    
    //hàm addNewOption: thêm một option cho danh sách
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    //hàm hiển thị danh sách option
    public void print(){
        int count = 1;
        System.out.println("_______" +title +"_______");
        for (String op : optionList) {
            System.out.println("" +count +"." +op);
            count++;
        }
    }
    //hàm getChoice(): thu nhập lựa chọn của người dùng
    public int getChoice(){
        int choice = Inputter.getAnInteger("Input your choice", 
                      "Your choice must between 1 and " +optionList.size(), 1, optionList.size());
        return choice;
    }
}
