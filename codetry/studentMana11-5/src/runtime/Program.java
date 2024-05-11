package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //muốn quản lí các sinh viên ta cần có một cái mảng
        ArrayList<Student> stuList = new ArrayList<>();
        
        //để xài các chức năng của menu cần hàm showMenu()
        int choose;
        do{
            
            showMenu();
            System.out.println("Mời bạn nhập lựa chọn nha: ");
            Scanner sc = new Scanner(System.in);
            choose = Integer.parseInt(sc.nextLine());//tránh trôi lệnh
            switch(choose){
                case 1:{
                    System.out.println("1. thêm mới một sinh viên");
                    Student newStudent = new Student();
                    newStudent.inputInfor();//nhập vào thông tin
                    //tạo ra một sin viên mới sau đó thêm vào mảng stuList
                    stuList.add(newStudent);
                    break;
                }
                case 2:{
                    System.out.println("2. hiển thị thông tin sinh viên");
                    if(stuList.isEmpty()){
                        System.out.println("Không có sinh viên nào!");
                    }else{
                        System.out.println("Thông tin sinh viên: ");
                        for (Student item : stuList) {
                            item.showInfor();
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.println("3. hiển thị max min theo điểm trung bình");
                    //giả sử thằng đầu tiên là giỏi nhất và gà nhất rồi tìm từ từ
                    float maxGpa = stuList.get(0).getGpa();
                    float minGpa = stuList.get(0).getGpa();
                    
                    //duyệt for
                    for (Student item : stuList) {
                        if(item.getGpa() > maxGpa){
                            maxGpa = item.getGpa();
                        }
                        if(item.getGpa() < minGpa){
                            minGpa = item.getGpa();
                        }
                    }
                    //in ra sinh viên giỏi nhất
                    System.out.println("Sinh viên giỏi nhất nè: ");
                    for (Student item : stuList) {
                        if(item.getGpa() == maxGpa){
                            item.showInfor();
                        }
                    }
                    //in ra sinh viên gà nhất
                    System.out.println("Sinh viên gà nhất nè: ");
                    for (Student item : stuList) {
                        if(item.getGpa() == minGpa){
                            item.showInfor();
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("4. tìm kiếm theo mã sinh viên");
                    System.out.println("Nhập vào IdStudent cần tìm: ");
                    String keyId = sc.nextLine();
                    boolean isFind = false;
                    for (Student item : stuList) {
                        if(item.getId().equals(keyId)){
                            isFind = true;
                            System.out.println("Sinh viên cần tìm là: ");
                            item.showInfor();
                        }
                    }
                    if(!isFind) System.out.println("Không tìm thấy!!!");
                    break;
                }
                case 5:{
                    //sắp xếp sinh viên tăng dần theo tên
                    System.out.println("5. sắp xếp sinh viên theo tên asc và hiển thị");
                    Collections.sort(stuList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t1.getName().compareTo(t2.getName()) > 0){
                                return 1;//swap
                            }else{
                                return -1;//giữ nguyên
                            }
                        }
                    });
                    
                    //in ra danh sách sau khi đã sắp xếp
                    for (Student item : stuList) {
                        item.showInfor();
                    }
                    break;
                }
                case 6:{
                    System.out.println("6. in ra sv có học bổng và hiển thị desc");
                    //kiểm tra xem thằng nào có học bổng và xếp theo thứ tự giảm dần
                    //sắp xếp giảm dần theo điểm
                    Collections.sort(stuList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t2.getGpa() > t1.getGpa()){
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    });
                    for (Student item : stuList) {
                        if(item.hasScholarship()){
                            item.showInfor();
                        }
                    }
                    break;
                }
                case 7:{
                    System.out.println("Xin chào và hẹn gặp lại!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong 1-7!!!");
                    break;
                }
            }
            
        }while(choose != 7);
        
    }
    public static void showMenu(){
        System.out.println("***Student Management Application***");
        System.out.println("1. nhập vào một sinh viên");
        System.out.println("2. hiển thị thông tin sinh viên");
        System.out.println("3. hiển thị max min theo điểm trung bình");
        System.out.println("4. tìm kiếm theo mã sinh viên");
        System.out.println("5. sắp xếp sinh viên theo tên asc và hiển thị");
        System.out.println("6. in ra sv có học bổng và hiển thị desc");
        System.out.println("7. thoát");
    }
}
/*
Quản lý danh sách sinh viên 
menu gồm các chức năng cơ bản
    1. nhập vào một sinh viên
    2. hiển thị thông tin sinh viên
    3. hiển thị max min theo điểm trung bình
    4. tìm kiếm theo mã sinh viên
    5. sắp xếp sinh viên theo tên asc và hiển thị
    6. in ra sv có học bổng và hiển thị desc
    7. thoát

trong chương trình này tôi muốn có
Person class
    bao gồm name, gender, yob
    có phễu có đối số, và không có đối số
    có getter và không có setter
    method showInFor
    method nhập thông tin người dùng

Student class
    sử dụng kế thừa để có name, gender, yob, của Person
    riêng Student thì muốn có thêm id, gpa, email
    phểu có đối số và k có đối số
    getter và có setter nhưng thông minh
    showInFor
*/