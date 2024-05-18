package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import utils.Inputter;

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
        String keyId = Inputter.getString("Input pet Id you wanna find: ", 
                            "That field is required!!!");//không có regex vì tìm k thấy thì thôi
        //nhập sai thì tìm không thấy thôi
        //dựa vào keyId tìm con pet
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");
            pet.showInfor();
        }
    }
    
    //hàm remove thú cưng theo id: hàm sẽ xin id và tìm pet rồi xóa
    public void removePetById(){
        String keyId = Inputter.getString("Input pet Id you wanna remove: ", 
                            "That field is required!!!");//không có regex vì tìm k thấy thì thôi
        //nhập sai thì tìm không thấy thôi
        //dựa vào keyId tìm con pet
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");//tìm thấy thông báo
            pet.showInfor();
            petList.remove(pet);//xóa pet
            System.out.println("Removing is successful!");
        }
    }
    
    //hàm update thú cưng theo id: hàm sẽ xin id và tìm pet rồi update
    public void updatePetById(){
        String keyId = Inputter.getString("Input pet Id you wanna update: ", 
                            "That field is required!!!");//không có regex vì tìm k thấy thì thôi
        //nhập sai thì tìm không thấy thôi
        //dựa vào keyId tìm con pet
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information before updating");//tìm thấy thông báo
            pet.showInfor();
            //một con pet có owner, color, weight//chó có necklace, mèo có ribbon cần update
            //nhưng id thì k được cập nhật
            System.out.println("Updating.....");
            String newOwner = Inputter.getString("Input owner: ",
                                            "that field is required");
            String newColor = Inputter.getString("Input color: ",
                                            "that field is required");
            double newWeight = Inputter.getADouble("Input weight: ",
                                            "that weight must between 1 and 100", 1, 100);
            pet.setOwner(newOwner);
            pet.setColor(newColor);
            pet.setWeight(newWeight);
            if(pet instanceof Dog){
                String newNecklace = Inputter.getString("Input necklace: ", "that field is required");
                ((Dog) pet).setNecklace(newNecklace);
            }else{
                String newRibbon = Inputter.getString("Input ribbon: ", "that field is required");
                ((Cat)pet).setRibbon(newRibbon);
            }
            System.out.println("Updating is successful!");
            
        }
    }   
    //method thêm mới một con chó
    public void addNewDog(){
        //muốn tạo ra một con chó thì cần đầy đủ thông tin sau đó ta bỏ thông tin
        //vào phểu rồi dúc ra con chó mới rồi add vào list
        //**Nhưng nếu nhập id trùng thì bắt nhập lại
        boolean isDup;
        String id;
        do{
            isDup = false;//tin ban đầu không có
            id = Inputter.getString("Input Dog's id: ", 
                    "Your id isn't matched DXXX!!!", "[Dd]\\d{3}").toUpperCase();
                    //nhập thoải mái nhưng chỉ lưu hoa
            Pet pet = searchPetById(id);
            if(pet != null){//bị trùng
                isDup = true;
                System.out.println("Id has been used");
            }
        }while(isDup);//khi còn trùng thì còn lập
        String owner = Inputter.getString("Input owner: ",
                                        "that field is required");
        String color = Inputter.getString("Input color: ",
                                        "that field is required");
        double weight = Inputter.getADouble("Input weight: ",
                                        "that weight must between 1 and 100", 1, 100);
        String necklace = Inputter.getString("Input necklace: ", "that field is required");

        //tạo ra con chó bằng phểu và thông tin trên
        Dog nDog = new Dog(id, owner, color, weight, necklace);
        petList.add(nDog);
        System.out.println("Adding is successfull");
            
    }
        
    //method thêm mới một con mèo
    public void addNewCat(){
        //muốn tạo ra một con mèo thì cần đầy đủ thông tin sau đó ta bỏ thông tin
        //vào phểu rồi dúc ra con mèo mới rồi add vào list
        //**Nhưng nếu nhập id trùng thì bắt nhập lại
        boolean isDup;
        String id;
        do{
            isDup = false;//tin ban đầu không có
            id = Inputter.getString("Input Cat's id: ", 
                    "Your id isn't matched CXXX!!!", "[Cc]\\d{3}").toUpperCase();
                    //nhập thoải mái nhưng chỉ lưu hoa
            Pet pet = searchPetById(id);
            if(pet != null){//bị trùng
                isDup = true;
                System.out.println("Id has been used");
            }
        }while(isDup);//khi còn trùng thì còn lập
        String owner = Inputter.getString("Input owner: ",
                                        "that field is required");
        String color = Inputter.getString("Input color: ",
                                        "that field is required");
        double weight = Inputter.getADouble("Input weight: ",
                                        "that weight must between 1 and 100", 1, 100);
        String ribbon = Inputter.getString("Input ribbon: ", "that field is required");

        //tạo ra con chó bằng phểu và thông tin trên
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        petList.add(nCat);
        System.out.println("Adding is successfull");
        
    }

    
    
}
