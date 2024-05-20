package runtime;

import data.PetManagement;
import ui.Menu;

public class Program {
    public static void main(String[] args) {
        /*
        muốn quản  lí được Dog và Cat thì ta cần dưa chúng về chung một mảng để
        quản lí. Muốn như vậy thì ta cần tạo ra thằng Pet lấy hết giá trị chung của Dog 
        và Cat đưa cho Pet giữ sau đó Pet sẽ trả ngược lại
        */
        PetManagement pm = new PetManagement();
        //kêu anh quản lí thêm dữ liệu đi
        pm.initData();
        
        //tạo ra anh quản lí menu
        Menu menu = new Menu("Pet Management System");
        menu.addNewOption("Add new dog");
        menu.addNewOption("Add new cat");
        menu.addNewOption("Print pet list");
        menu.addNewOption("Search pet order by id");
        menu.addNewOption("Update pet order by id");
        menu.addNewOption("Remove pet order by id");
        menu.addNewOption("Sort pet order by id");
        menu.addNewOption("Save file and quit");
        int choice;
        while(true){
            menu.print();
            choice = menu.getChoice();
            switch(choice){
                case 1:{
                    pm.addDog();
                    break;
                }
                case 2:{
                    pm.addCat();
                    break;
                }
                case 3:{
                    pm.showPetList();
                    break;
                }
                case 4:{
                    pm.searchPetById();
                    break;
                }
                case 5:{
                    pm.updatePetById();
                    break;
                }
                case 6:{
                    pm.removePetById();
                    break;
                }
                case 7:{
                    pm.sortPetOrderByWeight();
                    break;
                }
                case 8:{
                    System.out.println("See you again!");
                    return;
                }
            }
        }
        
    }
    
}
/*
Viết 1 chương trình quản lý thú cưng (DOG | CAT)
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng
    4. tìm kiếm thú cưng theo tên
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng
    8. save file and quit

    khi thêm mới id của pet k được trùng với id ở trong danh sách
    id của pet phải thỏa theo format "D001| C001"
    một con Pet có nhửng thuộc tính owner , color, weight
    
    Dog: necklace
    Cat: ribbon

    yêu cầu chung: nhập chuẩn | nhập bậy bạ là chữi
*/