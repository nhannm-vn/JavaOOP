/*
ui: user interface hiển thị giao diện người dùng
tạo ra anh menu để quản lí cái menu
cái menu có chức năng
+Thêm option vào trong list
+in ra các option
+cho người dùng nhập lựa chọn
 */
package ui;

import java.util.ArrayList;
import utils.Inputter;

public class Menu {
    //cái mảng lưu string các option:
    public ArrayList<String> menu = new ArrayList<>();
    private String title;
    
    //constructor

    public Menu(String title) {
        this.title = title;
    }
    
    //method add new option
    public void addNewOption(String newOption){
        menu.add(newOption);
    }
    
    //method in ra các option
    public void print(){
        int count = 1;
        System.out.println("_______***" +title +"***_______");
        for (String item : menu) {
            System.out.println("" +count +"." +item);
            count++;
        }
    }
    
    //method mời nhập choice
    public int getChoice(){
        return Inputter.getInt("Input your choice: ", "The choice must be between 1 and " +menu.size()
                , 1, menu.size());
        //có anh này rồi thì khỏi case default(ngoại lệ)
    }
}
