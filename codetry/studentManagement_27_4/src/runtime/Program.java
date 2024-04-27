package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        /*
        Đầu tiên ta xác định được:
        Student is a Person
        ==>con      cha. Vì vậy mà ta code Person trước
        */
        
        //muốn quản lí sinh viên thì cần cái mảng bỏ vào để quản lí chung
        //ta xài mảng co dãng
        ArrayList<Student> stuList = new ArrayList<>();
        
        //tạo ra con choose
        int choose;
        do{
            Scanner sc = new Scanner(System.in);
            showMenu();
            System.out.println("Mời nhập lựa chọn nha: ");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:{
                    System.out.println("Thêm mới một sinh viên: ");
                    Student newStudent = new Student();
                    newStudent.inputInfor();
                    
                    //sau khi tạo xong thì thêm vào list
                    stuList.add(newStudent);
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị thông tinh sinh viên trong list: ");
                    //check xem có sinh viên trong list không
                    boolean isFind = false;
                    for (Student student : stuList) {
                        student.showInfor();
                        isFind = true;
                    }
                    if(!isFind){//nếu không có sinh viên trong list
                        System.out.println("Trong list không có sinh viên");
                    }
                    
                    break;
                }
                case 3:{
                    System.out.println("Tìm sinh viên Giỏi nhất và sinh viên Gà nhất");
                    //giả định thằng đầu tiên giỏi nhất và gà nhất rồi tìm
                    float maxPoint = stuList.get(0).getGpa();
                    float minPoint = stuList.get(0).getGpa();
                    
                    //tìm trong list
                    for (Student student : stuList) {
                        if(student.getGpa() > maxPoint) maxPoint = student.getGpa();
                        if(student.getGpa() < minPoint) minPoint = student.getGpa();
                    }
                    //tìm thằng giỏi nhất
                    for (Student student : stuList) {
                        if(student.getGpa() == maxPoint){
                            System.out.println("Sinh viên giỏi nhất nè: ");
                            student.showInfor();
                        }
                    }
                    //tìm thằng gà nhất
                    for (Student student : stuList) {
                        if(student.getGpa() == minPoint){
                            System.out.println("Sinh viên gà nhất nè: ");
                            student.showInfor();
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("Tìm kiếm sinh viên dựa trên IdStudent: ");
                    System.out.println("Nhập vào Id: ");
                    String key = sc.nextLine();
                    
                    //xét coi có tìm thấy không
                    boolean isFind = false;
                    for (Student student : stuList) {
                        if(student.getId().equals(key)){
                            System.out.println("Sinh viên đó là: ");
                            student.showInfor();
                            isFind = true;
                        }
                    }
                    //nếu như không tìm thấy
                    if(!isFind){
                        System.out.println("Không tìm thấy sinh viên");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Sắp xếp sinh viên dựa trên tên theo asc: ");
                    //mình dùng Collections bộ công cụ chơi với mảng để sắp xếp
                    //xài anh trọng tài để sắp xếp trên một tiêu chí nhất định
                    Collections.sort(stuList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t2.getName().compareTo(t1.getName()) < 0){
                                return 1;//swap
                            }else{
                                return -1;//giữ nguyên
                            }
                        }
                    });
                    //sau khi sắp xếp thì in ra 
                    for (Student student : stuList) {
                        student.showInfor();
                    }
                    break;
                }
                case 6:{
                    System.out.println("Hiển thị sinh viên có học bỗng theo desc: ");
                    //đầu tiên sắp xếp giảm dần theo gpa trước
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
                    //hiển thị ra những thằng có học bỗng
                    System.out.println("Những thằng có học bỗng(desc): ");
                    for (Student student : stuList) {
                        if(student.hasScholarship()){
                            student.showInfor();
                        }
                    }
                    break;
                }
                case 7:{
                    System.out.println("Xin chào và hẹn gặp lại!!!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong khoảng 1-7");
                    break;
                }
            }
        
        }while(choose != 7);
        
        
    }
    //tạo hàm showMenu()
    public static void showMenu(){
        System.out.println("***Student Management System Application***");
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