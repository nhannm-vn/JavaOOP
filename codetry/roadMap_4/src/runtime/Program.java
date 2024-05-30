package runtime;

import data.Person;
import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //tao ra mot cai mang de quan li student
        ArrayList<Student> stuList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            //hien thi menu
            showMenu();
            System.out.println("Plz, Input your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    Student nStudent = new Student();
                    //nhap vao thong tin
                    nStudent.inputInfor();
                    //them student vao mang
                    stuList.add(nStudent);
                    System.out.println("Add new student successful!");
                    break;
                }
                case 2:{
                    if(stuList.isEmpty()){
                        System.out.println("List is empty!!!");
                    }else{
                        System.out.println("The student list: ");
                        for (Student student : stuList) {
                            student.showInfor();
                        }
                    }
                    System.out.println("Show student list successful!");
                    break;
                }
                case 3:{
                    //tim thang gioi nhat va ga nhat
                    //gia su thang dau tien gioi nhat va ga nhat
                    float minPoint = stuList.get(0).getGpa();
                    float maxPoint = stuList.get(0).getGpa();
                    //tim trong list ra max point va min point
                    for (Student student : stuList) {
                        if(student.getGpa() > maxPoint){
                            maxPoint = student.getGpa();
                        }
                        if(student.getGpa() < minPoint){
                            minPoint = student.getGpa();
                        }
                    }
                    //in ra 2 th do
                    for (Student student : stuList) {
                        if(student.getGpa() == maxPoint){
                            System.out.println("Strongest student: ");
                            student.showInfor();
                        }
                    }
                    for (Student student : stuList) {
                        if(student.getGpa() == minPoint){
                            System.out.println("Weakness student: ");
                            student.showInfor();
                        }
                    }
                    System.out.println("Find strongest ang weakness successful");
                    break;
                }
                case 4:{
                    System.out.println("Input student id you wanna find: ");
                    String keyId = sc.nextLine();
                    boolean isFind = false;
                    for (Student student : stuList) {
                        if(student.getId().equals(keyId)){
                            isFind = true;
                            System.out.println("The student you wanna find: ");
                            student.showInfor();
                        }
                    }
                    if(!isFind){//neu k co
                        System.out.println("Dont find student order by id!!!");
                    }
                    System.out.println("Find student order by id successful!");
                    break;
                }
                case 5:{
                    //sap xep sinh vien tang dan theo ten
                    //comparator
                    Comparator orderByName = new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t1.getName().compareTo(t2.getName()) > 0){
                                return 1;//swap
                            }else{
                                return -1;//giu nguyen
                            }
                        }
                    };
                    //sap xep thong qua Collections
                    Collections.sort(stuList, orderByName);
                    System.out.println("Sort student order by name successful");
                    break;
                }
                case 6:{
                    //sv co hoc bong la co gpa > 8 theo desc
                    Comparator<Student> orderByGpa = new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            return t1.getGpa() < t2.getGpa() ? 1 : -1;
                        }
                    };
                    Collections.sort(stuList, orderByGpa);
                    System.out.println("Student has scholarship: ");
                    for (Student student : stuList) {
                        if(student.hasScholarship()){
                            student.showInfor();
                        }
                    }
                    System.out.println("Find student has scholarship successful");
                    break;
                }
                case 7:{
                    System.out.println("See you again <3");
                    break;
                }
                default:{
                    System.out.println("Your choice must between 1 and 7!!!");
                    break;
                }
            }
            
        }while(choice != 7);//choice = 7  thi dung lai
        
    }
    public static void showMenu(){
        System.out.println("***System Management Student***");
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
