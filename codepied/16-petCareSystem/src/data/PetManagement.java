package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
PetManagement: là một cái khuôn để đúc ra anh quản lí danh sách thú cưng vậy nên
PetManagement sẽ sở hữu một danh sách thú cưng cụ thể là petList để quản lí và thêm
một đống method giúp xử lí danh sách này: thêm, sửa, xóa, sắp xếp, tìm, in
Mình bỏ hêt vào đây không bỏ vào main nữa nhe
    1. Thêm mới 1 con cún//5
    2. Thêm mới 1 con mèo//5
    3. in ra danh sách thú cưng//1 
    4. tìm kiếm thú cưng theo tên//3
        + hàm nhận vào id trả ra vị trí
        + hàm nhận vào id trả ra pet 
        + hàm xin id và thông báo kết quả (client) 
    5. update thú cưng theo id//4
    6. remove thú cưng theo id//4
    7. sắp xếp thú cưng theo trọng lượng//2
    8. save file and quit//6

*/
public class PetManagement {
    //PeManagement sẽ quản lí danh sách nên ta phải có danh sách
    ArrayList<Pet> petList = new ArrayList<>();
    //Ngoài list ra nó còn có các method để sử dụng
    //method initData(): hàm nhét 2 chó 2 mèo vào petList để test code
    
    public void initData(){
        petList.add(new Dog("D001", "Tuấn", "Red", 6.5, "I <3 U"));
        petList.add(new Dog("D002", "Toàn", "YẻLâu", 2.6, "Yellow"));
        petList.add(new Cat("C001", "Tùng", "Nâu", 4.2, "Mỹ Diệu"));
        petList.add(new Cat("C002", "Thông", "Tím", 5.2, "Thông Tìm"));
    }
    
    //in ra danh sách thú cưng showPetList()
    public void showPetList(){
        if(petList.isEmpty()){
            System.out.println("Nothing to print");
            return;//ngừng luôn
        }
        for (Pet item : petList) {
            item.showInfor();
        }
    }
    
    //sắp xếp thú cưng theo trọng lượng sortPetListByWeight
    public void sortPetListByWeight(){
        //tạo ra anh trọng tài tên 'orderByWeight'
        Comparator orderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                return t1.getWeight() > t2.getWeight() ? 1 : -1;
            }
        };
        
        //bỏ anh trọng tài và list vào và thông qua Collections để sắp xếp
        Collections.sort(petList, orderByWeight);
        //khong có in ra do mỗi khối có một nhiệm vụ riêng biệt
    }
    
    /*
    tìm kiếm thú cưng theo tên//3
        + hàm nhận vào id trả ra vị trí
        + hàm nhận vào id trả ra pet 
        + hàm xin id và thông báo kết quả (client) 
    */
    
    //+ hàm nhận vào id trả ra vị trí
    public int searchPetIndexById(String keyId){
        //vì search ra vị trí nên cần for thường
        for(int i = 0; i <= petList.size() - 1; i++){
            if(petList.get(i).getId().equals(keyId)){
                return i;
            }
        }
        return -1;//nếu không tìm thấy trả ra -1
    }
    
    //hàm nhận vào id và trả ra pet
    public Pet searchPetById(String keyId){
        int pos = searchPetIndexById(keyId);
        return pos == -1 ? null : petList.get(pos);
    }
    //hàm xin id và thông báo kết quả(client)
    public void searchPetById(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input pet id you wanna find: ");
        String keyId = sc.nextLine();
        //dựa vào keyId tìm con pet
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");
            pet.showInfor();
        }
    }
    
}
