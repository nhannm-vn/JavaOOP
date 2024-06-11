package runtime;

import data.Pet;
import data.PetManagement;
import ui.Menu;

public class Program {
    public static void main(String[] args) {
        //tao ra anh quan li
        PetManagement pm = new PetManagement();
        //anh quan li danh sach
        Menu menu = new Menu("~Pet Management System~");
        
        String url = "D:\\PIEDTEAM_JavaOOP\\JavaOOP\\codetry\\petCareSystem_6_10\\petListDoc.txt";
        pm.loadFromFile(url);
        //them cac option cho anh menu
        menu.addNewOption("Adding new a dog");
        menu.addNewOption("Adding new a cat");
        menu.addNewOption("Print pet list");
        menu.addNewOption("Search pet order by id");
        menu.addNewOption("Updating pet order by id");
        menu.addNewOption("Remove pet order by id");
        menu.addNewOption("Sort pet order by weight");
        menu.addNewOption("Save file and quit");
        
        
        int choice;
        while(true){
            menu.print();
            choice = menu.getChoice();
            switch(choice){
                case 1:{
                    pm.addNewDog();
                    break;
                }
                case 2:{
                    pm.addNewCat();
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
                    pm.saveToFile(url);
                    System.out.println("See you agian!");
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
