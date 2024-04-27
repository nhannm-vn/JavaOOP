package data;

import java.util.Scanner;

public class Student extends Person{
    //props riêng
    private String id;
    private float gpa;
    private String email;
    
    //constructor
    //full đối số
    //đổi đưa của thằng cha lên đầu
    public Student(String name, String gender, int yob, String id, float gpa, String email) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    
    //phểu không có đối số vậy cần hàm + inputInfor()

    public Student() {
    }
    
    //class có getter

    public String getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public String getEmail() {
        return email;
    }
    
    /*
    Setter thông minh là setter nhận vào giá trị kiếm tra coi có valid hay không
    nếu nó valid thì trả ra true và cho set. Không thì trả ra false và không set
    */

    public boolean setId(String id) {
        if(id.length() <= 0){
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        if(!id.matches("^[Ss][Ee]\\d{6}$")){
            System.err.println("Id phải có dạng SEDDDDDD với D là chữ số");
            return false;
        }
        this.id = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("Điểm gpa không hợp lí!!!");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public boolean setEmail(String email) {
        if(email.length() <= 0){
            System.err.println("Không được bỏ trống!!!");
            return false;
        }
        if(!email.contains("@")){
            System.err.println("Email có dạng không phù hợp!!!");
            return false;
        }
        if(!email.matches("^([a-z]*[0-9]*)[@][a-z]*[.][a-z]*[.]*[a-z]*$")){
            System.err.println("Email có dạng không phù hợp!!!");
            return false;
        }
        this.email = email;
        return true;
    }
    
    //hàm inputInfor() độ lại từ hàm của cha Person
    @Override
    public void inputInfor(){
        //gọi của cha ra để nhập thông tin
        //thay vì phải qua kia mở protected thì ta gọi của cha ra nhờ cha
        //ổng nhập dùm những cái của ổng
        super.inputInfor();//cha nhập mấy thông tin của ổng
        Scanner sc = new Scanner(System.in);
        //nhập cho cái phểu rỗng của con
        //nhờ có setter thông minh ta có thể bắt nhập valid
        //nhập vào id
        System.out.println("Nhập vào studentId: ");
        //kiểm tra bằng while nếu valid thì thôi
        //chưa valid thì bắt nhập lại đến valid
        while(!setId(sc.nextLine()));//nếu trả ra false thì ! ngược lại để làm tiếp
        
        System.out.println("Nhập vào gpa đi: ");
        while(!setGpa(Float.parseFloat(sc.nextLine())));
        
        System.out.println("Nhập vào email: ");
        while(!setEmail(sc.nextLine()));
    }
    
    //method showInfor
    //độ lại của thằng cha. Nhờ thằng cha in ra các thông tin của nó dùm
    //nên coi mấy cái \n coi sao cho in trên cùng 1 dòng
    @Override
    public void showInfor(){
        super.showInfor();//cha ơi in cho con. Thằng này đang nằm trên 1 dòng
        //in ra các thông tin của cha
        String str = String.format("|%-15s|%5.2f|%-20s|\n",
                                    id, gpa, email);
        System.out.printf(str);//in trên cùng 1 dòng hết rồi mới xuống dòng bằng \n chứ k bug
        
    }
    
    public boolean hasScholarship(){
        return gpa >= 8;
    }
}
/*
Student class
    sử dụng kế thừa để có name, gender, yob, của Person
    riêng Student thì muốn có thêm id, gpa, email
    phểu có đối số và k có đối số
    getter và có setter nhưng thông minh
    showInFor
*/