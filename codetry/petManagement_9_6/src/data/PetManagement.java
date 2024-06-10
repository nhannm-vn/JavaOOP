/*
Tao ra anh quan li danh sach pet no se giup ta quan li cac danh sach 

 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import utils.Inputter;

public class PetManagement {
    public ArrayList<Pet> petList = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);
    
    public void showPetList(){
        if(petList.isEmpty()){
            System.out.println("The pet list is empty");
            return;
        }
        System.out.println("The pet list: ");
        for (Pet item : petList) {
            item.showInfor();
        }
    }
    
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
    }
    
    //tim pet dua tren id tra ra pos
    public int getPetPosById(String keyId){
        for(int i = 0; i <= petList.size() - 1; i++){
            if(petList.get(i).getId().equals(keyId)){
                return i;
            }
        }
        return -1;
    }
    
    public Pet getPetById(String keyId){
        int pos = getPetPosById(keyId);
        return pos == -1 ? null : petList.get(pos);
    }
    
    public void getPetById(){
        String keyId = Inputter.getString("Input Id you wanna find: ", "The key Id not valid");
        Pet pet = getPetById(keyId);
        if(pet == null){
            System.out.println("Not find Pet!!!");
        }else{
            System.out.println("The pet you wanna find: ");
            pet.showInfor();
        }
    }
    
    public void removePetById(){
        String keyId = Inputter.getString("Input Id you wanna find: ", "The key Id not valid");
        Pet pet = getPetById(keyId);
        if(pet == null){
            System.out.println("Not find pet to remove");
        }else{
            System.out.println("Pet before remove: ");
            pet.showInfor();
            petList.remove(pet);
            System.out.println("Removing pet is successful");
        }
    }
    
    public void updatePetById(){
        String keyId = Inputter.getString("Input Id you wanna find: ", "The key Id not valid");
        Pet pet = getPetById(keyId);
        if(pet == null){
            System.out.println("Not find pet to update");
        }else{
            System.out.println("Pet before update: ");
            pet.showInfor();
            System.out.println("Updating.......");
            String owner = Inputter.getString("Input new owner: "
                                                , "Not be empty!");
            String color = Inputter.getString("Input new color: "
                                                , "Not be empty!");
            Double weight = Inputter.getDouble("Input new weight: ",
                                           "The weight must be 1 and 100" , 1, 100);
            pet.setOwner(owner);
            pet.setColor(color);
            pet.setWeight(weight);
            
            if(pet instanceof Dog){
                String necklace = Inputter.getString("Input new necklace: ",
                                            "Not be empty!");
                ((Dog) pet).setNeckLace(necklace);
            }else{
                String ribbon = Inputter.getString("Input new ribbon: ",
                                            "Not be empty!");
                ((Cat) pet).setRibbon(ribbon);
            }
            
            System.out.println("Updating pet is successful");
        }
    }
    
    public void addNewDog(){
        String id;
        boolean isDup = false;
        do{
            id = Inputter.getString("Input new id: ", "The Id not valid!"
                                                , "[D][d]d\\{3}").toUpperCase();
            for (Pet pet : petList) {
                if(pet.getId().equals(id)){
                    isDup = true;
                }
            }
        }while(isDup);
        String owner = Inputter.getString("Input new owner: "
                                                , "Not be empty!");
        String color = Inputter.getString("Input new color: "
                                                , "Not be empty!");
        Double weight = Inputter.getDouble("Input new weight: ",
                                           "The weight must be 1 and 100" , 1, 100);
        String necklace = Inputter.getString("Input new necklace: ",
                                            "Not be empty!");
        Dog nDog = new Dog(id, owner, color, weight, necklace);
        petList.add(nDog);
        System.out.println("Adding new dog is successful!");
    }
    public void addNewCat(){
        String id;
        boolean isDup = false;
        do{
            id = Inputter.getString("Input new id: ", "The Id not valid!"
                                                , "[D][d]d\\{3}").toUpperCase();
            for (Pet pet : petList) {
                if(pet.getId().equals(id)){
                    isDup = true;
                }
            }
        }while(isDup);
        String owner = Inputter.getString("Input new owner: "
                                                , "Not be empty!");
        String color = Inputter.getString("Input new color: "
                                                , "Not be empty!");
        Double weight = Inputter.getDouble("Input new weight: ",
                                           "The weight must be 1 and 100" , 1, 100);
        String ribbon = Inputter.getString("Input new ribbon: ",
                                            "Not be empty!");
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        petList.add(nCat);
        System.out.println("Adding new cat is successful!");
    }
    
    public boolean loadFromFile(String url){
        //tao Object file
        File f = new File(url);
        //doc file thong qua BufferReader
        try {//phai boc no thong qua try catch
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();//doc dong dau tien
            while(line != null){
                //bam ra bang StringTokenizer
                StringTokenizer str = new StringTokenizer(line, "|");
                String nId = str.nextToken().trim();
                String nOwner = str.nextToken().trim();
                String nColor = str.nextToken().trim();
                Double nWeight = Double.parseDouble(str.nextToken().trim());
                String special = str.nextToken().trim();
                if(nId.matches("[D]\\{3}")){
                    Dog dog = new Dog(nId, nOwner, nColor, nWeight, special);
                    petList.add(dog);
                }else{
                    Cat cat = new Cat(nId, nOwner, nColor, nWeight, special);
                    petList.add(cat);
                }
                line = reader.readLine();
                
            }
            return true;
        } catch (Exception e) {
            System.out.println("File is err " +e);
            return false;
        }
    }
        
    public boolean saveToFile(String url){
        File f = new File(url);
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Pet pet : petList) {
                writer.write(pet.toString());
                writer.write("\n");
            }
            writer.flush();
            return true;
        } catch (Exception e) {
            System.out.println("File err: " +e);
            return false;
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

*/