package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        //muốn quản lí bất kỳ các đối tượng thì ta phải đưa chúng về cùng một
        //mảng và quản lí nó
        //ArrayList là mảng co dảng
        ArrayList<Student> studentList = new ArrayList<>();
        
        //làm hàm showMenu()
        int choose;
        Scanner sc =  new Scanner(System.in);
        //giúp không trôi lệnh
        do{
            showMenu();
            System.out.println("Mời bạn nhập lựa chọn nhé: ");
            choose = Integer.parseInt(sc.nextLine());

            switch(choose){
                case 1:{
                    System.out.println("Thêm sinh viên: ");
                    //tạo một sinh viên mới
                    Student newStudent = new Student();
                    //gọi hàm  inputInfor ra
                    newStudent.inputInfor();
                    //nhét vào mảng
                    studentList.add(newStudent);
                    
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị thông tin sinh viên: ");
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
                    System.out.println("Tìm sinh viên Giỏi và Gà nhất");
                    float maxPoint = studentList.get(0).getGpa();
                    //không có hoặc vuông nên phải xài get(0)
                    float minPoint = studentList.get(0).getGpa();
                    
                    //tìm điểm bé nhất và lớn nhất
                    for (Student student : studentList) {
                        if(student.getGpa() > maxPoint) maxPoint = student.getGpa();
                        if(student.getGpa() < minPoint) minPoint = student.getGpa();
                    }
                    //tìm trong ds và in ra những thằng có điểm bằng max
                    System.out.println("Những thằng giỏi nhất nè: ");
                    for (Student student : studentList) {
                        if(student.getGpa() == maxPoint){
                            student.showInfor();
                        }
                    }
                    
                    System.out.println("Những thằng gà nhất nè: ");
                    for (Student student : studentList) {
                        if(student.getGpa() == minPoint){
                            student.showInfor();
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("Tìm sinh viên dựa trên IdStudent");
                    System.out.println("Nhập vào IdStudent: ");
                    String keyId = sc.nextLine();
                    //tìm trong danh sách xem có thằng nào có id  giống với vừa
                    //nhập  vào hay không nếu có thì in ra
                    boolean isFind = false;
                    for (Student student : studentList) {
                        if(student.getId().equals(keyId)){
                            student.showInfor();
                            isFind = true;
                        }
                    }
                    //nếu không có thì in ra không tìm thấy
                    if(!isFind){
                        System.out.println("Không tìm thấy sinh viên!!!");
                    }
                    
                    break;
                }
                case 5:{
                    //sắp xếp sinh  viên theo asc(tăng dần) rồi hiển thị
                    /*
                    **studentList là một chiếc mảng đặc biệt của Java cung cấp bộ
                    công cụ đặc biệt để thao tác với mảng Collections(bộ công cụ)
                    có nhiều công cụ(method) để làm việc với mảng như Math.
                    Còn Collection là bộ những cái mảng để lưu trữ
                    
                    **Collections.sort cung cấp cho ta hai cách để sắp xếp
                    *Đây là hiện tượng Overload(giống tên nhưng khác đầu vào)
                    
                    +sort(bình thường): dành cho danh sách có tính đố kỵ hoặc(comparable)
                    vd: so sánh một mảng toàn số nguyên. So sánh một danh sách 
                    bình thường không cần tiêu chí gì. Còn nếu như so sánh Student
                    thì phải ép tính đố kỵ vào trong nó vì nó. CHỨ KHÔNG BỎ SINH VIÊN
                    VÀO VÌ KHÔNG BIẾT SO SÁNH DỰA TRÊN TIÊU CHÍ NÀO
                    
                    +sort có anh trọng tài(comparator). Anh trọng tài sẽ nhìn vô
                    một tiêu chí nhất định để phân loại ra thằng nào lớn hơn và
                    thằng nào bé hơn
                    vd: so sánh một tiêu chí nhất định của Student
                    */
                    //xài kiểu sắp xếp có anh trọng tài
                    //đối tượng sắp xếp nằm trong studentList và so sánh nhau dựa trên student
                    //đưa con chuột tới cuối bấm crl  + space + enter
                    //anh trọng tài này chuyên xử lí Student
                    System.out.println("Sắp xếp sinh viên asc theo name");
                    Collections.sort(studentList, new Comparator<Student>() {
                        /*
                            Kỹ thuật anonymous(vừa vá vừa đổ) tạo ra anh trọng tài
                        có hàm compare bị lủng để cho mình vá. Để trống cho mình bổ
                        sung code vì ảnh không biết so sánh dựa trên tiêu chí gì
                        */
                        /*
                            Anh trọng tài không biết so sánh dựa trên yếu tố gì nên
                        ảnh để trống cho mình bổ sung code
                        */
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t2.getName().compareTo(t1.getName()) < 0){
                                return 1;//swapp
                            }else{
                                return -1;//không swap
                            }
                        }
                    });
                    //sau khi sắp xếp rồi thì mình in ra màn hình
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
                    //sắp xếp giảm dần theo gpa 
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t2.getGpa() > t1.getGpa()){
                                return 1;//swap
                            }else{
                                return -1;//giữ nguyên
                            }
                        }
                    });
                    //in ra có học bổng là có gpa > 8
                    //Collections.reverse(studentList);(muốn đảm ngược)
                    //trong danh sách có học bổng thì in ra những thằng gpa > 8
                    
                    //muốn chuyên nghiệp thì qua Student viết hàm check gpa > 8
                    //trả ra boolean đồng nhất với if bên này
                    
                    //kiểm trong danh sách sau khi sắp xếp thằng nào thỏa đk
                    //có học bổng thì in ra
                    for (Student student : studentList) {
                        if(student.hasScholarship()){
                            student.showInfor();
                        }
                    }
                    
                    break;
                }
                case 7:{
                    System.out.println("Hẹn gặp lại nhé");
                    break;
                }
                default:{
                    System.err.println("Lựa chọn phải nằm 1-7!!!");
                    break;
                }
            }
        }while(choose != 7);
    }
    public static void showMenu(){
        System.out.println("Student Management Application");
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