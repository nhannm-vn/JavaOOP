package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        //Student is a Person 
        //==> con      cha
    //chuẩn bị sẵn một cái menu
    //chuẩn bị một cái Scanner
        //muốn quản lí Student cần có một cái mảng để quản lí chung
        ArrayList<Student> stuList = new ArrayList<>();
        //mảng dành để quản lí nhưng thằng Student
        Scanner sc = new Scanner(System.in);
        int choose;
        
        do{
            showMenu();
            System.out.println("Vui lòng nhập lựa chọn nha: ");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:{
                    System.out.println("Thêm mới một sinh viên: ");
                    Student newStudent = new Student();
                    //nhập vào thông tin của Student
                    newStudent.inputInfor();
                    
                    //sau khi có sinh viên rồi thì ta add vào trong list
                    stuList.add(newStudent);
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị thông tin của sinh viên: ");
                    //check nếu trong list không có thì ta in ra là không có
                    boolean isFind = false;
                    for (Student student : stuList) {
                        student.showInfor();
                        isFind = true;
                    }
                    //nếu không in ra được sinh viên nào
                    if(!isFind){
                        System.out.println("Không có sinh viên nào trong list!");
                    }
                    
                    break;
                }
                case 3:{
                    System.out.println("Hiển thị sinh viên giỏi nhất và gà nhất");
                    //giả định thằng đầu tiên cao điểm nhất và ít điểm nhất
                    float maxPoint = stuList.get(0).getGpa();
                    float minPoint = stuList.get(0).getGpa();
                    
                    for (Student student : stuList) {
                        if(student.getGpa() > maxPoint){
                            maxPoint = student.getGpa();
                        }
                        if(student.getGpa() < minPoint){
                            minPoint = student.getGpa();
                        }
                    }
                    //in ra sinh viên giỏi nhất và gà nhất
                    System.out.println("Nhưng thằng giỏi nhất nè: ");
                    for (Student student : stuList) {
                        if(student.getGpa() == maxPoint) student.showInfor();
                    }
                    
                    System.out.println("Nhưng thằng gà nhất nè: ");
                    for (Student student : stuList) {
                        if(student.getGpa() == minPoint) student.showInfor();
                    }
                    break;
                }
                case 4:{
                    System.out.println("Tìm kiếm sinh viên theo IdStudent: ");
                    System.out.println("Nhập vào Id cần tìm: ");
                    String newId;
                    newId = sc.nextLine();
                    //giả sử trường hợp không tìm thấy
                    boolean isFind = false;
                    for (Student student : stuList) {
                        if(student.getId().equals(newId)){
                            isFind = true;
                            student.showInfor();
                        }
                    }
                    if(!isFind){
                        System.out.println("Không tìm thấy!!!");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Sắp xếp sinh viên theo tên asc: ");
                    //để sắp xếp ta cần xài một thằng Collections là nơi
                    //lưu trữ các method chơi với mảng
                    //để sắp xếp học sinh dựa trên một tiêu chí nhất định cần
                    //comparator: anh trọng tài
                    Collections.sort(stuList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            //kĩ thuật anonymous vừa vá vừa đổ bên trong Program
                            if(t2.getName().compareTo(t1.getName()) < 0){
                                //thằng nào bé hơn thì swap ra đầu
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    });
                    
                    //sau khi đã sắp xếp thì ta in ra
                    for (Student student : stuList) {
                        student.showInfor();
                    }
                    break;
                }
                case 6:{
                    //in ra sinh viên có học bỗng theo dsc
                    System.out.println("In ra sinh viên có học bỗng theo desc: ");
                    //sắp xếp giảm dần trước
                    //cũng xài comparator
                    Collections.sort(stuList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            //nếu thằng nào lớn hơn thì đưa ra đầu
                            if(t2.getGpa() > t1.getGpa()){
                                return 1;
                            }else{
                                return -1;//ko swap
                            }
                        }
                    });
                    //những thằng có học bỗng là có gpa > 8
                    //viết hasScholarship cho chuyên nghiệp
                    for (Student student : stuList) {
                        if(student.hasScholarship()){
                            student.showInfor();
                        }
                    }
                    break;
                }
                case 7:{
                    System.out.println("Cảm ơn và hẹn gặp lại!!!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong khoảng 1-7!!!");
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