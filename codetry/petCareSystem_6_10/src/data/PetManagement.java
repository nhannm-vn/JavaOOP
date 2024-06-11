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
/*
day la anh quan ly, anh nam danh sach va cac chuc nang 
*/
public class PetManagement {
    //tao ra cai danh sach va dua cho anh
    public static ArrayList<Pet> petList = new ArrayList<>();
    
    //tu hieu co pheu rong
    
    //in ra danh sach thu cung
    public void showPetList(){
        if(petList.isEmpty()){
            System.out.println("The pet list is empty!");
        }else{
            System.out.println("The list management pet: ");
            for (Pet item : petList) {
                item.showInfor();
            }
        }
    }
    
    //sap xep thu cung
    public void sortPetOrderByWeight(){
        //tao ra anh trong tai
        Comparator orderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                return t1.getWeight() > t2.getWeight() ? 1 : -1;
            }
        };
        //sap xep
        Collections.sort(petList, orderByWeight);
        System.out.println("Sort pet list order by weight successful!");
    }
    
    //tim kiem dua tren id tra ra vi tri
    public int searchPosPetById(String keyId){
        for(int i = 0; i <= petList.size() - 1; i++){
            if(petList.get(i).getId().equals(keyId)){
                return i;
            }
        }
        return -1;//neu k thay
    }
    
    //tim kiem va dua ra con pet
    public Pet searchPetById(String keyId){
        int pos = searchPosPetById(keyId);
        return pos == -1 ? null : petList.get(pos);
    }
    
    //tim kiem va bao cho nguoi dung
    public void searchPetById(){
        //keu nguoi dung nhap vao
        String keyId = Inputter.getString("Input pet id you wanna find: ", 
                                            "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("Not find pet!");
        }else{
            System.out.println("The pet information: ");
            pet.showInfor();
        }
        System.out.println("Search pet order by id successful!");
    }
    
    //remove thu cung theo id
    public void removePetById(){
        //keu nguoi dung nhap vao
        String keyId = Inputter.getString("Input pet id you wanna remove: ", 
                                            "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("Not find pet!");
            return;
        }else{
            System.out.println("The pet information before remove: ");
            pet.showInfor();
            petList.remove(pet);
        }
        System.out.println("Remove pet order by id successful!");
    }
    
    public void updatePetById(){
        //keu nguoi dung nhap vao
        String keyId = Inputter.getString("Input pet id you wanna updating: ", 
                                            "Not be empty!");
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("Not find pet!");
            return;
        }else{
            System.out.println("The pet information before update: ");
            pet.showInfor();
            System.out.println("Updating....");
            //nhap vao may cai can update
            String owner = Inputter.getString("Input new owner: ", "Not be empty!");
            String color = Inputter.getString("Input new color: ", "Not be empty!");
            double weight = Inputter.getDouble("Input new weight: ", "The weight must be 1 and 100"
                                                                        , 1, 100);
            pet.setOwner(owner);
            pet.setColor(color);
            pet.setWeight(weight);
            //neu doi tuong do la cat hoac dog
            if(pet instanceof Dog){
                String necklace = Inputter.getString("Input new necklace: ", "Not be empty!");
                ((Dog) pet).setNecklace(necklace);
            }else{
                String ribbon = Inputter.getString("Input new ribbon: ", "Not be empty!");
                ((Cat) pet).setRibbon(ribbon);
            }
        }
        System.out.println("Updating pet order by id successful!");
    }
    
    public void addNewDog(){
        String id;
        boolean isDup;
        do{
            isDup = false;
            id = Inputter.getString("Input new id: ", "The id not valid!",
                "[dD]\\d{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.out.println("The id has been used!");
            }
        }while(isDup);
        String owner = Inputter.getString("Input new owner: ", "Not be empty!");
        String color = Inputter.getString("Input new color: ", "Not be empty!");
        double weight = Inputter.getDouble("Input new weight: ", "The weight must be 1 and 100"
                                                                        , 1, 100);
        String necklace = Inputter.getString("Input new necklace: ", "Not be empty!");
        Dog nDog = new Dog(id, owner, color, weight, necklace);
        petList.add(nDog);
        System.out.println("Adding new dog is successful!");
    }
    
    public void addNewCat(){
        String id;
        boolean isDup;
        do{
            isDup = false;
            id = Inputter.getString("Input new id: ", "The id not valid!",
                "[Cc]\\d{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.out.println("The id has been used!");
            }
        }while(isDup);
        String owner = Inputter.getString("Input new owner: ", "Not be empty!");
        String color = Inputter.getString("Input new color: ", "Not be empty!");
        double weight = Inputter.getDouble("Input new weight: ", "The weight must be 1 and 100"
                                                                        , 1, 100);
        String ribbon = Inputter.getString("Input new ribbon: ", "Not be empty!");
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        petList.add(nCat);
        System.out.println("Adding new Cat is successful!");
    }
    
    //doc file
    public boolean loadFromFile(String url){
        File f = new File(url);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();//doc dong dau tien ne
            
            while(line != null){
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String owner = st.nextToken().trim();
                String color = st.nextToken().trim();
                double weight = Double.parseDouble(st.nextToken().trim());
                String special = st.nextToken().trim();
                if(id.matches("[D]\\d{3}")){
                    Dog dog = new Dog(id, owner, color, weight, special);
                    petList.add(dog);
                }else{
                    Cat cat = new Cat(id, owner, color, weight, special);
                    petList.add(cat);
                }
                line = reader.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("File err goi: " +e);
            return false;
        }
    }
    
    public boolean saveToFile(String url){
        File f = new File(url);
        try {
            OutputStreamWriter writter = new OutputStreamWriter(new FileOutputStream(f));
            for (Pet pet : petList) {
                writter.write(pet.toString());
                writter.write("\n");
            }
            writter.flush();
            return true;
        } catch (Exception e) {
            System.out.println("File err goi: " +e);
            return false;
        }
    }
}
/*
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng
    4. tìm kiếm thú cưng theo tên
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng
    8. save file and quit
*/