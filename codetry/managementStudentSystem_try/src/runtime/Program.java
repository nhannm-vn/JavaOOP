
package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        //muốn quản lí thì cần có một cái mảng chung
        ArrayList<Student> studentList = new ArrayList<>();
        //mảng quản lí Student tên      =     tạo ra cái mảng
        //muốn chọn chức năng cần có một thằng choose
        int choose;
        Scanner sc = new Scanner(System.in);
        do{
            showMenu();
            System.out.println("Mời nhập lựa chọn nha: ");
            choose = sc.nextInt();
            //cho sự lựa chọn
            switch(choose){
                case 1:{
                    System.out.println("Thêm sinh viên vào danh sách: ");
                    //tạo ra Student
                    Student newStudent = new Student();
                    //hàm nhập thông tin vào
                    newStudent.inputInfor();
                    //thêm Student vào list
                    studentList.add(newStudent);
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị thông tin sinh viên trong list: ");
                    //nếu trong list trống sinh viên trả ra true
                    if(studentList.isEmpty()){
                        System.err.println("Danh sách trống!!!");
                        break;
                    }
                    for (Student student : studentList) {
                        student.showInfor();
                    }
                    break;
                }
                case 3:{
                    System.out.println("Hiển thị sinh viên Giỏi nhất và Gà nhất");
                    //giả định là thằng có điểm lớn nhất và thằng có điểm bé nhất
                    //là thằng đầu tiên
                    float maxPoint = studentList.get(0).getGpa();
                    float minPoint = studentList.get(0).getGpa();

                    //tìm xem gpa nào lớn nhất và bé nhất
                    for (Student student : studentList) {
                        if(student.getGpa() > maxPoint) maxPoint = student.getGpa();
                        if(student.getGpa() < minPoint) minPoint = student.getGpa();
                    }
                    //nếu hợp lệ thì in ra luôn
                    for (Student student : studentList) {
                        if(student.getGpa() == maxPoint){
                            System.out.println("Sinh viên giỏi nhất: ");
                            student.showInfor();
                        }
                    }
                    for (Student student : studentList) {
                        if(student.getGpa() == minPoint){
                            System.out.println("Sinh viên gà nhất");
                            student.showInfor();
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("Tìm kiếm sinh viên theo id: ");
                    String newId;
                    while(true){
                        System.out.println("Nhập vào ID muốn tìm kiếm: ");
                        Scanner cv = new Scanner(System.in);
                        newId = cv.nextLine();
                        if(newId.length() <= 0){
                            System.err.println("Không được bỏ trống");
                            break;
                        }
                        boolean isValid = newId.matches("^[S](E|S)\\d{6}$");
                        if(isValid){
                            break;
                        }else{
                            System.err.println("ID cần tìm không valid");
                        }
                    }
                    
                    
                    //tìm trong ArrayList xem có ID đó không
                    //kiểm tra xem  ID có tồn tại k
                    //size(): trả ra số lượng phần tử có trong mảng
                    int flag;
                    flag = 0;
                    for(int i = 0; i <= studentList.size() - 1; i++){
                        if(studentList.get(i).getId().equals(newId)){
                            System.out.println("Sinh viên cần tìm nè: ");
                            studentList.get(i).showInfor();
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 0){
                        System.out.println("Không có sinh viên theo ID");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Sắp xếp sinh viên theo ascii: ");
                    for(int i = 0; i <= studentList.size() - 1; i++){
                        for(int j = i + 1; j <= studentList.size() - 2; j++){
                            if(studentList.get(j).getName()
                                    .compareTo(studentList.get(i).getName()) == -1){
                                
                                                                
                            }
                        }
                    }
                    
                    break;
                }
                case 6:{
                    break;
                }
                case 7:{
                    System.out.println("Hẹn gặp lại nhé");
                    break;
                }
                default:{
                    System.err.println("Lựa chọn phải nằm trong 1-7!!!");
                    break;
                }
            }
        }while(choose != 7);
    }
    //hàm showMenu()
    public static void showMenu(){
        System.out.println("***Student Management System***");
        System.out.println("1. nhập vào một sinh viên");
        System.out.println("2. hiển thị thông tin sinh viên");
        System.out.println("3. hiển thị max, min theo điểm trung bình");
        System.out.println("4. tìm kiếm theo mã sinh viên");
        System.out.println("5. sắp xếp sinh viên theo tên asc và hiển thị");
        System.out.println("6. in ra sv có học bỗng và hiển thị desc");
        System.out.println("7. thoát");
    }
}
/*
//Vì Student muốn có các thuộc tính của Person cho nên Student nhận Person làm cha
nên phải code Person class trước

Quản lý danh sách sinh viên
menu gồm các chức năng cơ bản
    1. nhập vào một sinh viên
    2. hiển thị thông tin sinh viên
    3. hiển thị max, min theo điểm trung bình
    4. tìm kiếm theo mã sinh viên
    5. sắp xếp sinh viên theo tên asc và hiển thị
    6. in ra sv có học bỗng và hiển thị desc
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
    getter và có setter thông minh
    showInFor
*/