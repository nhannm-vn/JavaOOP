/*
PetManagement: đúc anh quản lí dùng để quản lí các chức năng của mảng chứa các con vật
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
import java.util.Scanner;
import java.util.StringTokenizer;
import utils.Inputter;

public class PetManagement {
    //mảng để quản lí các con Pet
    public ArrayList<Pet> petList = new ArrayList<>();
    
    //method initData(): giúp thêm giá trị và list để dễ test code
    public void initData(){
        //thêm 2 chó 2 mèo
        petList.add(new Dog("D001", "Diep", "While", 4.7, "Gau"));
        petList.add(new Dog("D002", "Lam", "Grey", 5.2, "Le"));
        petList.add(new Cat("C001", "Tung", "Yellow", 2.9, "YẻLow"));
        petList.add(new Cat("C002", "Thong", "Purple", 8.2, "ThongTim"));
    }
    
    //method in ra các Pet có trong danh sách
    public void showPetInfor(){
        //kiểm tra xem có con nào trong list ko, nếu có thì in ra
        //không có thì báo là ko 
        if(petList.isEmpty()){
            System.out.println("Nothing pet in list!");
        }
        for (Pet item : petList) {
            item.showInfor();
        }
        System.out.println("Show information pet successful!");
    }
    
    //sắp xếp thú cưng theo cân nặng
    public void sortPetByWeight(){
        //đầu tiên tạo ra anh trọng tài để so sánh dựa trên tiêu chí weight
        Comparator oderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                return t1.getWeight() > t2.getWeight() ? 1 : -1;
            }
        };
        
        //bỏ anh trọng tài và list cần so sánh vào để sắp xếp
        Collections.sort(petList, oderByWeight);
        System.out.println("Sort pet by weight successful!");
        //ở đây không có in ra vì mình có method in riêng
        
    }
    
    //tìm kiếm pet index dựa vào id 
    public int searchPetIndexById(String keyId){
        //vì tìm index nên cần for thường
        for(int i = 0; i <= petList.size() - 1; i++){
            if(petList.get(i).getId().equals(keyId)){
                return i;
            }
        }
        return -1;
    }
    
    //tìm kiếm pet dựa vào id
    public Pet searchPetById(String keyId){
        int pos = searchPetIndexById(keyId);
        return pos != -1 ? petList.get(pos) : null;
    }
    //nhờ người dùng nhập
    //overload
    public void searchPetById(){
        String keyId = Inputter.getString("Input pet id you wanna find: ",
                                                    "Not be empty!");//ko cần regex vì nhập sai thì k tìm thấy
        Pet pet = searchPetById(keyId);
        if(pet != null){
            System.out.println("The pet information: ");
            pet.showInfor();
        }else{
            System.out.println("The pet not exist!");
        }
        System.out.println("Searching pet is successful!");
    }
    
    //method removing con pet
    public void removePetById(){
        String keyId = Inputter.getString("Input pet id you wanna remove: ",
                                                    "Not be empty!");//ko cần regex vì nhập sai thì k tìm thấy
        Pet pet = searchPetById(keyId);
        if(pet != null){
            System.out.println("The pet information before removing: ");
            pet.showInfor();
            //in ra thông tin pet xong rồi mới xóa
            petList.remove(pet);
            System.out.println("Removing pet is successful!");
        }else{
            System.out.println("The pet not exist!");
        }
    }
    
    //method updating con pet
    public void updatingPetById(){
        String keyId = Inputter.getString("Input pet id you wanna updating: ",
                                                    "Not be empty!");//ko cần regex vì nhập sai thì k tìm thấy
        Pet pet = searchPetById(keyId);
        System.out.println("Updating...");
        if(pet != null){
            System.out.println("The pet information before updating: ");
            pet.showInfor();
            //in ra thông tin pet xong rồi mới upadting
            String newOwner = Inputter.getString("Input new owner: ", "Not be empty!");
            String newColor = Inputter.getString("Input new color: ", "Not be empty!");
            double newWeight = Inputter.getADouble("Input new weight: ", "Not be valid!");
            //kiểm tra xem là chó hay mèo thì sẽ có necklace hoặc ribbon riêng
            pet.setColor(newColor);
            pet.setOwner(newOwner);
            pet.setWeight(newWeight);
            if(pet instanceof Dog){
                String newNeckLace = Inputter.getString("Input new necklace: ", "Not be empty!");
                ((Dog) pet).setNecklace(newNeckLace);
            }else{
                String newRibbon = Inputter.getString("Input new ribbon:", "Not be empty!");
                ((Cat)pet).setRibbon(newRibbon);
            }
            System.out.println("Updating pet is successful!");
        }else{
            System.out.println("The pet not exist!");
        }
    }
    
    public void addNewDog(){
        String id;
        
        while(true){
            id = Inputter.getString("Input id:", "Id need matches DXXX", 
                                            "[Dd]\\d{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet == null){//nếu k có thì break, có thì lặp hoài
                break;
            }else{
                System.out.println("Id has been used!");
            }
        }
        //input vào các thuộc tính khác
        String owner = Inputter.getString("Input owner: ", "Not be empty!");
        String color = Inputter.getString("Input color: ", "Not be empty!");
        double weight = Inputter.getADouble("Input weight: ", "Not be valid!");
        String neckLace = Inputter.getString("Input necklace: ", "Not be empty!");
        
        //tạo ra con chó mới
        Dog nDog = new Dog(id, owner, color, weight, neckLace);
        //thêm vào list
        petList.add(nDog);
        System.out.println("Adding new dog successful!");
    }
    
    public void addNewCat(){
        String id;
        
        while(true){
            id = Inputter.getString("Input id:", "Id need matches DXXX", 
                                            "[Cc]\\d{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet == null){//nếu k có thì break, có thì lặp hoài
                break;
            }else{
                System.out.println("Id has been used!");
            }
        }
        //input vào các thuộc tính khác
        String owner = Inputter.getString("Input owner: ", "Not be empty!");
        String color = Inputter.getString("Input color: ", "Not be empty!");
        double weight = Inputter.getADouble("Input weight: ", "Not be valid!");
        String ribbon = Inputter.getString("Input ribbon: ", "Not be empty!");
        
        //tạo ra con mèo mới
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        //thêm vào list
        petList.add(nCat);
        System.out.println("Adding new dog successful!");
    }
    /*
    //hàm đọc file
    public boolean loadFromFile(String url){
        //tạo ra object file từ url
        File f = new File(url);
        //bỏ vào try catch để dù có lỗi vẫn chạy tiếp
        try {
            //để đọc file ta phải nhờ thằng BufferReader
            //để BufferReader đọc được thì ta phải chuyển file thành FileReader
            BufferedReader reader = new BufferedReader(new FileReader(f));
            //đọc từng dòng để xử lí
            String line = reader.readLine();
            while(line != null){
                //dùng tokenizer để băm nhỏ từng thằng trong line
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String owner = st.nextToken().trim();
                String color = st.nextToken().trim();
                double weight = Double.parseDouble(st.nextToken().trim());
                //vì mình chưa biết là con gì nên để cái băm sau cùng là special
                String special = st.nextToken().trim();
                if(special.matches("[Dd]\\{3}")){
                    Dog pet = new Dog(id, owner, color, weight, special);
                    petList.add(pet);
                }else{
                    Cat pet = new Cat(id, owner, color, weight, special);
                    petList.add(pet);
                }
                //thêm con đó vào list
                //sau đó đọc dòng tiếp theo
                line = reader.readLine();
            }
            return true;//nếu đọc được hết k bị gì
        } catch (Exception e) {
            //nếu đọc file bị lỗi thì trả ra false và ném ra để đọc lỗi
            System.out.println("File bị lỗi gòi nè: " + e);
            return false;
        }
    }*/
    
    //hàm đọc file
    public boolean loadFromFile(String url){
        //tạo ra objecet file
        File f = new File(url);
        try {
            //để đọc file cần BufferReader đọc được FileReader
            BufferedReader reader = new BufferedReader(new FileReader(f));
            //đọc dòng đầu tiên
            String line = reader.readLine();
            while(line != null){
                //băm ra từng thằng trong 1 line
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String owner = st.nextToken().trim();
                String color = st.nextToken().trim();
                double weight = Double.parseDouble(st.nextToken().trim());
                //còn special là necklace hoặc ribbon
                String special = st.nextToken().trim();
                if(special.matches("[Dd\\{3}]")){
                    Dog nDog = new Dog(id, owner, color, weight, special);
                    petList.add(nDog);
                }else{
                    Cat nCat = new Cat(id, owner, color, weight, special);
                    petList.add(nCat);
                }
                //đọc dòng tiếp theo
                line = reader.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("File bi loi goi " +e);
            return false;
        }
    }
    //lưu file sau khi xử lí
    public boolean saveToFile(String url){
        File f = new File(url);
        try {
            //này là thằng giúp mình ghi
            OutputStreamWriter writter = new OutputStreamWriter(new FileOutputStream(f));
            for (Pet pet : petList) {
               writter.write(pet.toString());
               writter.write("\n");
            }
            //save roi dong
            writter.flush();
            return true;
        } catch (Exception e) {
            System.out.println("File bi loi goi");
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