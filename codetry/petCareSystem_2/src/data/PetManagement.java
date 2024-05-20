/*
PetManagement: là cái khuôn chuyên đúc ra những anh chuyên quản lí danh sách Pet
anh này sẽ là một class chứa các chức năng giúp quản lí hiệu quả danh sách mà không
cần triển khai bên main

 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import utils.Inputter;

public class PetManagement {
    //tạo ra cái mảng để cho ảnh quản
    //cái mảng phải để public để khác package cũng có thể thấy. Vì bthg ta tạo mảng trong main
    public ArrayList<Pet> petList = new ArrayList<>();
    
    //đầu tiên ta cần một hàm để nạp giá trị vào cho mảng
    //method initData()
    public void initData(){
        //thêm 2 con chó và 2 con mèo vào
        petList.add(new Dog("D001", "Mây", "Xanh", 4.6, "xanhanh"));
        petList.add(new Dog("D002", "Wind", "Vàng", 4.2, "Yẻlow"));
        petList.add(new Cat("C001", "Diep", "Xám", 3.1, "Lé"));
        petList.add(new Cat("C002", "Diepvotam", "Trắng", 2.4, "GâuGâu"));
    }
    
    //method in ra danh sách thú cưng
    public void showPetList(){
        //nếu trong danh sách không có thì mình báo không có luôn
        if(petList.isEmpty()){
            System.out.println("The list is empty!");
        }else{
            for (Pet item : petList) {
                item.showInfor();
            }
        }
        System.out.println("Show pet list successful!");
    }
    
    //sắp xếp thú cưng dựa trên cân nặng
    public void sortPetOrderByWeight(){
        //mình cần tạo ra anh trọng tài comparator để anh đứng ra xem xét giữa 2 Object
        //thì ai lớn hơn và dựa trên tiêu chí cụ thể
        Comparator orderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                return t1.getWeight() > t2.getWeight() ? 1 : -1;
            }
        };
        //sau khi ta đã có anh trọng tài comparator rồi thì ta cần thông qua 
        //Collections là bộ công cụ chơi với mảng ta sẽ bỏ list và comparator vào
        Collections.sort(petList, orderByWeight);
        //sau khi sắp xếp rồi thì báo thôi chứ k in ra vì mình có sẵn một thằng
        //sẽ giúp mình in ra
        System.out.println("Sort pet order by weight successful!");
    }
    
    //method tìm pet index dựa vào key id 
    public int searchPetIndexById(String keyId){
        //để trả ra được index cụ thể thì ta cần con for bthg
        for(int i = 0; i <= petList.size() - 1; i++){
            if(petList.get(i).getId().equals(keyId)) return i;
        }
        return -1;//nếu không tìm thấy thì trả ra -1
    }
    
    //method tìm pet trả ra pet dựa vào key id
    public Pet searchPetById(String keyId){
        int pos = searchPetIndexById(keyId);
        //tận dùng hàm tìm pos trên kia áp xuống
        return pos == -1 ? null : petList.get(pos);
    }
    
    //method nhờ người dùng nhập vào KeyId và tìm sau đó thông báo
    //Overload
    public void searchPetById(){
        String keyId = Inputter.getString("Input pet id you wanna find: ", "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet you wanna find not exist!");
        }else{
            System.out.println("The pet information: ");
            pet.showInfor();
        }
        System.out.println("Search pet by id successful!");
    }
    
    //remove thú cưng dựa vào id
    public void removePetById(){
        String keyId = Inputter.getString("Input pet id you wanna remove: ", "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet you wanna remove not exist!");
        }else{
            System.out.println("The pet information before remove: ");
            pet.showInfor();
            petList.remove(pet);
        }
        System.out.println("Remove pet by id successful!");
    }
    
    //update thú cưng dựa vào id
    public void updatePetById(){
        String keyId = Inputter.getString("Input pet id you wanna update: ", "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet you wanna remove not exist!");
        }else{
            System.out.println("The pet information before update: ");
            pet.showInfor();
            //up gì up chứ k được up id
            String newOwner = Inputter.getString("Input new owner: ", "Not be empty!");
            String newColor = Inputter.getString("Input new color: ", "Not be empty!");
            double newWeight = Inputter.getDouble("Input new weight: ", "Not be empty!");
            
            //set lại cho các prop
            pet.setOwner(newOwner);
            pet.setColor(newColor);
            pet.setWeight(newWeight);
            
            //update ribbon hay necklace phụ thuộc con đó là con gì
            if(pet instanceof Dog){
                String newNeckLace = Inputter.getString("Input new necklace: ", "Not be empty!");
                ((Dog) pet).setNecklace(newNeckLace);
            }else{
                String newRibbon = Inputter.getString("Input new ribbon: ", "Not be empty!");
                ((Cat) pet).setRibbon(newRibbon);
            }
        }
        System.out.println("Update pet by id successful!");
    }
    
    //thêm mới một con cún
    public void addDog(){
        //kêu người dụng nhập vào các thuộc tính của con vật sau đó ta đúc ra con 
        //mới rồi add vào list
        String id = Inputter.getString("Input new id: ", "Not be empty!");
        String owner = Inputter.getString("Input new owner: ", "Not be empty!");
        String color = Inputter.getString("Input new color: ", "Not be empty!");
        double weight = Inputter.getDouble("Input new weight: ", "Not be empty!");
        String neckLace = Inputter.getString("Input new necklace: ", "Not be empty!");
        
        //đúc ra con chó mới
        Dog nDog = new Dog(id, owner, color, weight, neckLace);
        //thêm vào danh sách
        petList.add(nDog);
        System.out.println("Add new dog is successful!");
    }
    
    //thêm mới một con cún
    public void addCat(){
        //kêu người dụng nhập vào các thuộc tính của con vật sau đó ta đúc ra con 
        //mới rồi add vào list
        String id = Inputter.getString("Input new id: ", "Not be empty!");
        String owner = Inputter.getString("Input new owner: ", "Not be empty!");
        String color = Inputter.getString("Input new color: ", "Not be empty!");
        double weight = Inputter.getDouble("Input new weight: ", "Not be empty!");
        String ribbon = Inputter.getString("Input new ribbon: ", "Not be empty!");
        
        //đúc ra con mèo mới
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        //thêm vào danh sách
        petList.add(nCat);
        System.out.println("Add new cat is successful!");
    }
    
}
/*
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng//ok
    4. tìm kiếm thú cưng theo tên//ok
    5. update thú cưng theo id//ok
    6. remove thú cưng theo id//ok
    7. sắp xếp thú cưng theo trọng lượng//ok
    8. save file and quit
*/