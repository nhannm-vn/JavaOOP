/*
PetManagement là cái khuôn chuyên đúc ra những anh quản lí danh sách Pet
ảnh có nhưng chức năng giúp ta thao tác với danh sách
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import utils.Inputter;

public class PetManagement {
    //đầu tiên ảnh sẽ nắm một danh sách chứa các con Pet
    ArrayList<Pet> petList = new ArrayList<>();
    
    //in ra danh sách thú cưng
    public void printPetList(){
        if(petList.isEmpty()){
            System.out.println("Nothing pet in list");
            return;
        }
        System.out.println("The pet list: ");
        for (Pet pet : petList) {
            pet.showInfor();
        }
        System.out.println("Show pet list is successful");
    }
    
    //sắp xếp thú cưng theo trọng lượng
    public void sortPetOrderByWeight(){
        //tạo ra anh trọng tài đứng giữa phán xử dựa vào cân nặng
        Comparator orderByWeigth = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                return t1.getWeight() > t2.getWeight() ? 1 : -1;
            }
        };
        
        //sắp xếp
        Collections.sort(petList, orderByWeigth);
        System.out.println("Sort pet order by weight is successful");   
    }
    
    //tìm kiếm index thú cưng dựa vào id
    public int searchPetIndexById(String keyId){
        //tìm dựa trên for thường
        for(int i = 0; i <= petList.size() - 1; i++){
            if(petList.get(i).getId().equals(keyId)){
                return i;
            }
        }
        return -1;
    }
    //tìm pet dựa trên id
    public Pet searchPetById(String keyId){
        int pos = searchPetIndexById(keyId);
        return pos == -1 ? null : petList.get(pos);
    }
    //tìm pet thông báo theo yêu cầu người dùng
    public void searchPetById(){
        String keyId = Inputter.getString("Input keyId you wanna find: ", "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet you wanna find not exist!");
            return;
        }else{
            System.out.println("The pet information: ");
            pet.showInfor();
        }
        System.out.println("Search pet order by id successful");
    }
    
    //remove pet
    public void removePetById(){
        String keyId = Inputter.getString("Input keyId you wanna remove: ", "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet you wanna remove not exist!");
            return;
        }else{
            System.out.println("The pet information before remove: ");
            pet.showInfor();
            petList.remove(pet);
        }
        System.out.println("Remove pet is successful");
    }
    
    //upadate pet
    public void updatePetById(){
        String keyId = Inputter.getString("Input keyId you wanna update: ", "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet you wanna update not exist!");
            return;
        }else{
            System.out.println("The pet information before update: ");
            pet.showInfor();
            String nOwner = Inputter.getString("Input new owner: ", "Not be empty!");
            String nColor = Inputter.getString("Input new color: ", "Not be empty!");
            Double nWeight = Inputter.getDouble("Input new weight: ", "weight must between 1 and 100", 
                                            1, 100);
            //set lai thong tin
            pet.setOwner(nOwner);
            pet.setColor(nColor);
            pet.setWeight(nWeight);
            
            //neu la cho thi co necklace con meo thi co ribbon
            if(pet instanceof Dog){
                String nNecklace = Inputter.getString("Input new necklace: ", "Not be empty!");
                ((Dog) pet).setNecklace(nNecklace);
            }else{
                String nRibbon = Inputter.getString("Input new ribbon: ", "Not be empty!");
                ((Cat) pet).setRibbon(nRibbon);
            }
        }
        System.out.println("Updating pet is successful");
    }
    
    //them moi mot con cho
    public void addNewDog(){
        //thêm mới một id thì không được trùng, trùng thì ép nhạp lại
        //check id không trùng
        boolean isDup;
        String id;
        do{
            isDup = false;
            id = Inputter.getString("Input your dog id: ", "The dog id must be DXXX!", 
                                                    "[Dd]\\{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.out.println("Id has been used!");
            }
        }while(isDup);
        String owner = Inputter.getString("Input your dog owner: ", "Not be empty!");
        String color = Inputter.getString("Input your dog color: ", "Not be empty!");
        Double weight = Inputter.getDouble("Input your dog weight: ", "weight must between 1 and 100", 
                                        1, 100);
        String necklace = Inputter.getString("Input your dog necklace: ", "Not be empty!");
        
        //tạo ra con chó mới
        Dog nDog = new Dog(id, owner, color, weight, necklace);
        petList.add(nDog);
        System.out.println("Add dog is successful");
    }
     //them moi mot con meo
    public void addNewCat(){
        //thêm mới một id thì không được trùng, trùng thì ép nhạp lại
        //check id không trùng
        boolean isDup;
        String id;
        do{
            isDup = false;
            id = Inputter.getString("Input your dog id: ", "The cat id must be DXXX!", 
                                                    "[Cc]\\{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.out.println("Id has been used!");
            }
        }while(isDup);
        String owner = Inputter.getString("Input your dog owner: ", "Not be empty!");
        String color = Inputter.getString("Input your dog color: ", "Not be empty!");
        Double weight = Inputter.getDouble("Input your dog weight: ", "weight must between 1 and 100", 
                                        1, 100);
        String ribbon = Inputter.getString("Input your dog ribbon: ", "Not be empty!");
        
        //tạo ra con chó mới
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        petList.add(nCat);
        System.out.println("Add cat is successful");
    }
    
    //đọc file
    public boolean loadFromFile(String url){
        //tạo object file
        File f = new File(url);
        try {
            //để đọc file ta cần
            BufferedReader reader = new BufferedReader(new FileReader(f));
            //đọc dòng đầu tiên
            String line = reader.readLine();
            while(line != null){//đọc đến khi nào hết thì thôi
                //băm ra từng cục thông qua Stringtokenizer
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String owner = st.nextToken().trim();
                String color = st.nextToken().trim();
                Double weight = Double.parseDouble(st.nextToken().trim());
                //con một cái là special mình k biết chắc con gì
                String special = st.nextToken().trim();
                if(special.matches("[Dd]\\{3}")){
                    Dog nDog = new Dog(id, owner, color, weight, special);
                    petList.add(nDog);
                }else{
                    Cat nCat = new Cat(id, owner, color, weight, special);
                    petList.add(nCat);
                }
                //đọc dòng tiếp theo
                line = reader.readLine();
            }
            return true;//nếu đúng trả ra true
        } catch (Exception e) {
            //báo và trả ra false nếu file lỗi
            System.out.println("File lỗi gòi nè: " + e);
            return false;
        }
    }
    
    //save file
    public boolean saveToFile(String url){
        File f = new File(url);
        try {
            //save thông qua 
            OutputStreamWriter writter = new OutputStreamWriter(new FileOutputStream(f));
            for (Pet pet : petList) {
                writter.write(pet.toString());//luu thong tin tung dong
                writter.write("\n");
            }
            writter.flush();//ket thuc
            return true;
        } catch (Exception e) {
            System.out.println("File bị lỗi gòi " + e);
            return false;
        }
    }
}
/*
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng//r
    4. tìm kiếm thú cưng theo tên//r
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng//r
    8. save file and quit
*/