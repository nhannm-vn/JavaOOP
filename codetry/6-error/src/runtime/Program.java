package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String str = "Nguyen Minh Nhan";
        String regex = "^([A-Z][a-z]*)( [A-Z][a-z]*)*$";
        
        checkString(str, regex);
        
        Scanner sc = new Scanner(System.in);
        int age;
        
        try{
            System.out.println("Nhập vào tuổi đi: ");
            age = sc.nextInt();
            if(age < 10 || age > 30){
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Sai rồi cậu");
        }
        
        System.out.println("ahihi đúng rồi");
        
        
    }
    //phải có static để tất cả trong class xài chung và không được phân mảnh
    //hàm trong program phải có static
    public static void checkString(String str, String regex){
        System.out.println(str.matches(regex));
    }
    
}
