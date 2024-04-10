package runtime;

//error and regex

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String str = "nguyennhanhumada@gmail.com";
        //check mail fpt
        String regex = "^([a-z]*)[s][se]1{1}[0-9]{5}[@]fpt[.]edu[.]vn$"; 
        
        checkMail(str, regex);
        checkMail("trannmse182080@fpt.edu.vn", regex);
        
        Scanner sc = new Scanner(System.in);
        int age;
        
        try{
            System.out.println("Nhập vào số tuổi đi: ");
            age = sc.nextInt();
            
            if(age < 10 || age > 30){
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Vui lòng nhập lại");
        }
        System.out.println("ahihi đồ chó");
        
    }//viết cùng bậc vs main phải static hết và cùng viết chung và xài tại class
    public static void checkMail(String str, String regex){
        System.out.println(str.matches(regex));
    }
    
}
