/*
Tạo ra anh quản lí Menu và chưa các method làm vc với menu
+thêm mới option
+show optionList
+cho người dùng nhập lựa chọn
 */
package ui;//user inteface: hiển thị giao diện người dùng

import java.util.ArrayList;
import utils.Inputter;

public class Menu {
    public ArrayList<String> optionList = new ArrayList<>();
    public String title;
    //dùng để lưu các option mình muốn

    public Menu(String title) {
        this.title = title;
    }
    
    //getter

    public String getTitle() {
        return title;
    }
    
    
    //thêm option
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    
    //in ra các option
    public void print(){
        System.out.println("_______" + title + "_______");
        int count = 1;
        for (String op : optionList) {
            System.out.println("" +count +"." +op);
            count++;
        }
    }
    
    //cho người dùng chọn
    public int getChoice(){
        int choice = Inputter.getAnInteger("Input your choice: ", 
                "The choice must between 1 and " +optionList.size(), 1, optionList.size());
        return choice;
    }
}
