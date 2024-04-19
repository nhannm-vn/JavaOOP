package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //muốn quản lí sinh viên thì cần có cái mảng để quản lí chung
        ArrayList<Student> studentList = new ArrayList<>();
        
        int choose;
        do{
            Scanner sc = new Scanner(System.in);
            showMenu();
            System.out.println("Xin mời nhập lựa chọn nhé: ");
            choose = Integer.parseInt(sc.nextLine());

            switch(choose){
                case 1:{
                    System.out.println("Thêm vào sinh viên: ");
                    Student newStudent = new Student();
                    newStudent.inputInfor();//vì phểu rổng nên kêu ngta nhập thông tin vào

                    //thêm sinh viên vào mảng
                    studentList.add(newStudent);
                    break;
                }
                case 2:{
                    System.out.println("Hiên thị thông tin sinh viên: ");
                    if(studentList.isEmpty()){
                        System.out.println("Danh sách trống");
                    }
                    System.out.println("Danh sách sinh viên: ");
                    for (Student student : studentList) {
                        student.showInfor();
                    }
                    break;
                }
                case 3:{
                    System.out.println("Hiển thị sinh viên Giỏi nhất và sinh viên Gà nhất: ");
                    //giả định thằng đầu tiên điểm cao nhất và thấp nhất
                    float maxPoint = studentList.get(0).getGpa();
                    float minPoint = studentList.get(0).getGpa();

                    for (Student student : studentList) {
                        if(student.getGpa() > maxPoint){
                            maxPoint = student.getGpa();
                        }
                        if(student.getGpa() < minPoint){
                            minPoint = student.getGpa();
                        }
                    }
                    System.out.println("Sinh viên giỏi nhất: ");
                    for (Student student : studentList) {
                        if(student.getGpa() == maxPoint){
                            student.showInfor();
                        }
                    }
                    System.out.println("Sinh viên gà nhất: ");
                    for (Student student : studentList) {
                        if(student.getGpa() == minPoint){
                            student.showInfor();
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("Tìm kiếm sinh viên dựa trên IDStudent: ");
                    System.out.println("Nhập vào IdStudent cần  tìm: ");
                    String keyId  = sc.nextLine();
                    boolean isFind  = false;
                    for (Student student : studentList) {
                        if(student.getId().equals(keyId)){
                            System.out.println("Sinh viên cần tìm là: ");
                            student.showInfor();
                            isFind  = true;
                        }
                    }
                    //lúc đầu là không có là false, khi có rồi là true
                    if(!isFind){//nếu như không tìm thấy
                        System.out.println("Không tìm thấy!!!");
                    }
                    break;
                }
                case 5:{
                    //sắp xếp sinh viên theo tên asc và hiển thị
                    //sắp xếp theo tăng dần là: ascending
                    System.out.println("Sắp xếp theo tên ascending");
                    /*
                        StudentList là  một chiếc mảng  đặc biệt của java và java
                    cung cấp một bộ công cụ giúp thao tác với mảng: Collections
                    (bộ công cụ) có nhiểu công cụ method như Math
                    còn Collection(bộ những cái mảng để lưu trữ)
                    
                    Collections.sort có 2 cách sắp xếp.
                    **Hiện tượng Overload(giống tên khác đầu vào)
                    +bỏ vào bình thường(sort này dành cho danh sách có tính đố kỵ, hoặc dạng cơ bản(comparable))
                    vd: danh sách chứa toàn số nguyên. Đây là một danh sách bthg 
                    sắp xếp dựa trên giá trị nên bỏ vào sắp xếp đc do số thì chỉ
                    so sánh giá trị. CHỨ KHÔNG BỎ SINH VIÊN VÌ KHÔNG BIẾT SO 
                    SÁNH TRÊN MẶT NÀO(phải sắp xếp dựa trên một tiêu chí cụ thể)
                    +có comparator(anh trọng tài)
                    anh trọng  tài(comparator) sẽ nhìn vô danh sách phân loại ra 
                    thằng nào lớn hơn và ai bé hơn 
                    
                    */
                    //xài kiểu sắp xếp có anh trọng tài
                    //đối tượng sắp xếp nằm trong studentList và so sánh nhau dựa trên student
                    //đưa con chuột tới cuối bấm crl  + space + enter
                    //anh trọng tài này chuyên xử lí Student
                    Collections.sort(studentList, new Comparator<Student>() {
                        //kỹ thuật anonymous khi tạo mới một anh trọng tài phải vá
                        //lỗ thủng. Ta phải vừa vá vừa đổ
                        //anh trọng tài chuyên đi phán xử xem ai lớn hơn hoặc bé hơn
                        //ảnh để rỗng bởi vì so sánh một đối tượng con người cụ thể
                        //một con người thì so sánh dựa trên rất nhiều tiêu chí
                        /*anh trọng tài không biết so sánh trên yếu tố gì nên
                        ảnh để cho mình bổ sung code
                        */
                        
                        @Override
                        //ảnh hỏi mình nếu mình có hai thằng sinh viên t1, t2 thì
                        //mình so sánh như thế nào?   
                        //ảnh chỉ một lần là tôi sắp xếp hết luôn
                        public int compare(Student t1, Student t2) {
                            //dựa trên tiêu chí name
                            //nếu tên của thằng t1 > t2 
                            if(t1.getName().compareTo(t2.getName()) > 0){
                                return 1;//swap
                            }else{
                                return -1;//nghĩa là không làm gì hết
                            }
                        }
                    });
                    //hiển thị
                    for (Student student : studentList) {
                        student.showInfor();
                    }
                    break;
                }
                case 6:{
                    //sắp xếp theo điểm giảm giần: desc
                    //và in ra sinh viên có học bổng
                    System.out.println("In ra sinh viên có học bổng theo desc");
                    //sắp xếp giảm dần theo điểm trước rồi mới in ra theo học bổng
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t2.getGpa() > t1.getGpa()){
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    });
                    //Collections.reverse(studentList);(muốn đảm ngược)
                    //trong danh sách có học bổng thì in ra những thằng gpa > 8
                    
                    //muốn chuyên nghiệp thì qua Student viết hàm check gpa > 8
                    //trả ra boolean đồng nhất với if bên này
                    for (Student student : studentList) {
                        if(student.hasScholarship()){//in ra sinh viên có học bỗng
                            student.showInfor();
                        }
                    } 
                    break;
                }
                case 7:{
                    System.out.println("Cảm ơn và hẹn gặp lại!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn phải nằm trong khoảng 1-7!!!");
                }
            }
        }while(choose != 7);
    }
    //hàm showMenu()
    public static void showMenu(){
        System.out.println("***Student Management System***");
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
    method Student class
    sử dụng kế thừa để có name, gender, yob, của Person
    riêng Student thì muốn có thêm id, gpa, email
    phểu có đối số và k có đối số
    getter và có setter nhưng thông minh
    showInForshowInFor
    method nhập thông tin người dùng

Student class
    sử dụng kế thừa để có name, gender, yob, của Person
    riêng Student thì muốn có thêm id, gpa, email
    phểu có đối số và k có đối số
    getter và có setter nhưng thông minh
    showInFor
*/