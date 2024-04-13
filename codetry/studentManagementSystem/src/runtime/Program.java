package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        //Muốn quản lí sinh viên thì ta cần có cái mảng để chứa sinh viên
        //Tạo mảng ArrayList là mảng có khả năng co, giản
        //Tạo cái mảng co, giản chỉ để lưu Student
        ArrayList<Student> studentList = new ArrayList<>();
        
        int choose;//lưu lựa chọn
        Scanner sc = new Scanner(System.in);
        
        do{
            showMenu();
            System.out.println("Vui lòng nhập lựa chọn nha");
            choose = Integer.parseInt(sc.nextLine());//tránh trôi lệnh
            switch(choose){
                case 1:{
                    System.out.println("Thêm sinh viên");
                    Student newStudent = new Student();//tạo ra một sinh viên mới
                    newStudent.inputInfor();//nhập thông tin vào
                    studentList.add(newStudent);//nhét sv mới vào
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị danh sách sinh viên");
                    if(studentList.isEmpty()){
                        System.out.println("Không có sinh viên nào cả");
                        break;
                    }
                    //nếu có thì in
                    for (Student student : studentList) {
                        student.showInfor();
                    }
                    break;
                }
                case 3:{
                    System.out.println("Tìm sinh viên Giỏi nhất và Gà nhất");
                    //giả định cho thằng đầu tiên
                    float maxPoint = studentList.get(0).getGpa();
                    //không có hoặc vuông nên phải xài get(0)
                    float minPoint = studentList.get(0).getGpa();

                    //tìm điểm bé nhất và lớn nhất
                    for (Student student : studentList) {
                        if(student.getGpa() > maxPoint) maxPoint = student.getGpa();
                        if(student.getGpa() < minPoint) minPoint = student.getGpa();
                    }
                    //tìm và in ra thằng có điểm lớn nhất trong ds:
                    System.out.println("Sinh viên giỏi nhất: ");
                    for (Student student : studentList) {
                        if(student.getGpa() == maxPoint){
                            student.showInfor();
                        }
                    }
                    //tìm và in ra thằng có điểm bé nhất trong ds:
                    System.out.println("Sinh viên gà nhất: ");
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
                    break;
                }
                default:{
                    System.out.println("Phải nhập từu 1 - 7 nhé");
                    break;
                }
            }
        }while(choose != 7);
        
        
    }
    //hàm menu: vì cùng cấp với main nên phải static luôn
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