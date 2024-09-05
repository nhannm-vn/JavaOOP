package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //muốn quản lí bọn chúng thì ta cần có cái mảng để quán lí
        //ta sẽ xài cái mảng xịn để quảng lí chúng
        ArrayList<Student> stdList = new ArrayList<>();
        //tạo ra cái scanner luôn
        Scanner sc = new Scanner(System.in);
        //tạo ra con choose lựa chọn
        int choose = 0;
        do{
            //hiển thị bảng lựa chọn trước
            menu();
            System.out.println("Mời bạn nhập vào lựa chọn của mình nhé: ");
            choose = Integer.parseInt(sc.nextLine());
            
            //cấu trúc chức năng
            switch(choose){
                case 1:{
                    //tạo ra một sinh viên mới
                    Student newStudent = new Student();
                    //để cho nó tự thêm thông tin vào
                    newStudent.inputInfor();
                    //thêm sinh viên mới vào list
                    stdList.add(newStudent);
                    break;
                }
                case 2:{
                    //hiển thị danh sách sinh viên
                    //nếu danh sách trống thì báo không có
                    if(stdList.isEmpty()){
                        System.out.println("Danh sách student trống");
                        break;
                    }else{
                        System.out.println("Danh sách sinh viên nè: ");
                        for (Student item : stdList) {
                            item.showInfor();
                        }
                        break;
                    }
                }
                case 3:{
                    //hiển thị max min dựa vào gpa
                    //tìm thằng có gpa max và qpa min và từ đó thông báo
                    double maxGpa = stdList.get(0).getGpa();
                    double minGpa = stdList.get(0).getGpa();
                    for (Student item : stdList) {
                        if(item.getGpa() > maxGpa){
                            maxGpa = item.getGpa();
                        }
                        if(item.getGpa() < minGpa){
                            minGpa = item.getGpa();
                        }
                    }
                    //tìm ra những thằng giỏi nhất
                    System.out.println("Những thằng giỏi nhất nè: ");
                    for (Student item : stdList) {
                        if(item.getGpa() == maxGpa){
                            item.showInfor();
                        }
                    }
                    //tìm ra những thằng gà nhất nè
                    System.out.println("Những thằng gà nhất nè: ");
                    for (Student item : stdList) {
                        if(item.getGpa() == minGpa){
                            item.showInfor();
                        }
                    }
                    break;
                }
                case 4:{
                    //mã sv này không cần chặn nhập sai hay gì hết
                    //vì nếu nhập tào lao thì tìm không có thôi
                    //tạo ra con boolean để tìm nếu không có thì báo
                    boolean isFind = false;
                    System.out.println("Nhập vào id của sinh viên cần tìm: ");
                    String keyId = sc.nextLine();
                    //duyệt qua tìm thằng đó
                    for (Student item : stdList) {
                        if(item.getId().equalsIgnoreCase(keyId)){
                            isFind = true;
                            item.showInfor();
                        }
                    }
                    if(!isFind){
                        System.out.println("Không tìm thấy sinh viên!");
                        break;
                    }
                    break;
                }
                case 5:{
                    //sắp xếp sinh viên tăng dần theo tên và hiển thị
                    //để sắp xếp ta sẽ dùng Collections: bộ công cụ chơi với mảng
                    //tạo ra anh trọng tài chỉ cho ảnh cách sắp xếp
                    Comparator orderByName = new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t1.getName().compareTo(t2.getName()) > 1){
                                return 1;
                            }else{
                                return -1;//không làm gì cả
                            }
                        }
                    };
                    Collections.sort(stdList, orderByName);
                    //in ra danh sách
                    for (Student item : stdList) {
                        item.showInfor();
                    }
                    break;
                }
                case 6:{
                    //in ra sinh viên có học bỗng theo điểm giảm dần
                    //sắp xếp trước rồi mới tìm và in
                    Comparator orderByGpa = new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t1.getGpa() < t2.getGpa()){
                                return 1;
                            }else{
                                return -1;//không làm gì cả
                            }
                        }
                    };
                    Collections.sort(stdList, orderByGpa);
                    //tìm ra và in ra những thằng có học bỗng
                    System.out.println("Những thằng có học bỗng là: ");
                    for (Student item : stdList) {
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
                    System.err.println("Lựa chọn phải nằm trong khoảng 1-7!!!");
                    break;
                }
            };
        }while(choose != 7);
    }
    //làm hàm menu() vì nó là hàm nằm cùng cấp vs main nên là static
    //mặc khác chỉ có mình nó và không phân mảnh cũng như không ai chịu trách nhiệm nên static
    public static void menu(){
        System.out.println("Student Management Application");
        System.out.println("1. thêm vào một sinh viên");
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