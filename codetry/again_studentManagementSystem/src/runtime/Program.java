package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //muốn quản lí trước tiên ta cần cái mảng 
        //ArrayList: mảng co giản
        ArrayList<Student> studentList = new ArrayList<>();
        
        //tạo ra choose cho người dùng chọn
        int choose;
        Scanner sc = new Scanner(System.in);
        do{
            showMenu();
            System.out.println("Vui lòng nhập lựa chọn nha: ");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:{
                    System.out.println("Thêm vào sinh viên");
                    Student newStudent = new Student();
                    newStudent.inputInfor();
                    //vì bên này student cũng là một kiểu dữ liệu luôn gòi
                    //nên k cần tạo biến gì hết
                    studentList.add(newStudent);                
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị danh sách sinh viên");
                    //trường hợp trong list trống
                    if(studentList.isEmpty()){
                        System.out.println("Không có sinh viên nào cả");
                        break;
                    }
                    for (Student student : studentList) {
                        student.showInfor();
                    }
                    break;
                }
                case 3:{
                    System.out.println("Tìm ra sinh viên Giỏi nhất và Gà nhất");
                    //giả định thằng đầu tiên dựa trên gpa
                    float maxPoint = studentList.get(0).getGpa();
                    float minPoint = studentList.get(0).getGpa();

                    for (Student student : studentList) {
                        if(student.getGpa() > maxPoint) maxPoint = student.getGpa();
                        if(student.getGpa() < minPoint) minPoint = student.getGpa();
                    }
                    System.out.println("Sinh viên giỏi nhất");
                    for (Student student : studentList) {
                        if(student.getGpa() == maxPoint){
                            student.showInfor();
                        }
                    }
                    System.out.println("Sinh viên gà nhất");
                    for (Student student : studentList) {
                        if(student.getGpa() == minPoint){
                            student.showInfor();
                        }
                    }
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
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
                    System.out.println("Yêu cầu nằm trong 1-7 nhe mày !!!");
                }
            }
        }while(choose != 7);
    }
    //hàm showMenu()
    public static void showMenu(){
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