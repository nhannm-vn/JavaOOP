package runtime;

import data.PetManagement;
import ui.Menu;

public class Program {
    public static void main(String[] args) {
        //Muốn có Dog và Cat thì ta cần có khuôn để đúc ra chúng
        //Nhưng để đưa về quản lí chung một mảng thì ta cần một thằng
        //lớn hơn là Pet. Ta đưa hết cái chung cho nó.
        PetManagement pm = new PetManagement();
        //add dữ liệu vào
        //pm.initData();
        String url = "D:\\PIEDTEAM_JavaOOP\\JavaOOP\\codetry\\petCareSystem\\petListDoc.txt";
        //thay vì phải xài method để add dữ liệu vào thì ta sẽ dùng hàm cho đọc file
        pm.loadFromFile(url);
        
        //tạo ra một anh quản lí menu
        Menu menu = new Menu("Pet Management System");
        
        //add các option cho menu
        menu.addNewOption("Add new Dog");
        menu.addNewOption("Add new Cat");
        menu.addNewOption("Show list pet");
        menu.addNewOption("Search pet order by id");
        menu.addNewOption("Update pet order by id");
        menu.addNewOption("Remove pet order by id");
        menu.addNewOption("Sort pet order by weight");
        menu.addNewOption("Save file and quit");
        
        while(true){
            menu.print();
            int choice = menu.getChoice();
            //không cần default vì đã chặn 1 tới size bên kia
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
                    pm.showPetInfor();
                    break;
                }
                case 4:{
                    pm.searchPetById();
                    break;
                }
                case 5:{
                    pm.updatingPetById();
                    break;
                }
                case 6:{
                    pm.removePetById();
                    break;
                }
                case 7:{
                    pm.sortPetByWeight();
                    break;
                }
                case 8:{
                    pm.saveToFile(url);
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