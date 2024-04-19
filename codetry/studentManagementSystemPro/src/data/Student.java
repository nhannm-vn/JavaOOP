package data;
//vì muốn có những cái cảu thằng cha nên ta sẽ nhập Person làm cha để được nó
//cho các thuộc tính của nó

import java.util.Scanner;

public class Student extends Person {
    //các thuộc tính riêng chỉ có nó mới có
    private String id;
    private float gpa;
    private String email;
    
    //phểu constructor có đối số
    //phải đổi những cái chung hoặc của cha thì quý nên đưa lên đầu
    public Student(String name, String gender, int yob, String id, float gpa, String email) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    
    //constructor không có đối số

    public Student() {
    }
    
    //getter

    public String getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public String getEmail() {
        return email;
    }
    
    //setter thông minh
    //là setter nhận vào giá trị thì kiêm tra xem nó có valid hay chưa
    //nếu valid trả ra true và set ngược lại trả ra flase không xét

    public boolean setId(String id) {
        if(id.length() <= 0){
            System.err.println("Không được bỏ trống");
            return false;
        }
        if(!id.matches("SE\\d{6}")){
            System.err.println("id phải có dạng SEDDDDDD với D là chữ số");
            return false;
        }
        this.id = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("Gpa không hợp lí!!!");
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
        if(!email.matches("^[a-z]*\\d{0,6}[@][a-z]*[.][a-z]*([.][a-z]*)*$")){
            System.err.println("Email không hợp lí");
            return false;
        }
        if(!email.contains("@")){
            System.err.println("email không hợp lí!!!");
            return false;
        }
        this.email = email;
        return true;
    }
    
    //vì có phểu không có đối số nên ta cần hàm để nhập thông tin
    @Override//độ lại hàm của cha Person để xài
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        super.inputInfor();
        //thay vì phải protected bên kia thì ta chỉ cần gọi thằng cha ra 
        //kêu cha nhập những cái mà nó có
        
        //nhập của thằng con
        //nhập thông qua check của setter. Nhờ có setter thông minh mà ta có thể
        //ép nhập chuẩn
        //nhập id
        System.out.println("Nhập vào IDStudent: ");
        while(!setId(sc.nextLine()));//ra đúng thì dừng, ra k đúng thì làm tiếp
        
        //nhập gpa
        System.out.println("Nhập vào gpa: ");
        while(!setGpa(Float.parseFloat(sc.nextLine())));
        
        //nhập vào email
        System.out.println("Nhập vào email: ");
        while(!setEmail(sc.nextLine()));
    }
    
    //hàm showInfor()
    @Override
    public void showInfor(){
        //gọi cha kêu in ra cái của cha
        super.showInfor();
        String str = String.format("|%s|%.2f|%s|\n", id, gpa, email);
        System.out.printf(str);
    }
    
    //hàm kiểm tra xem có hasScholarship
    public boolean hasScholarship(){
        return this.gpa > 8;//nếu gpa  > 8 thì trả ra true 
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