package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        System.out.println("Enter a String: ");
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        //System.out.println(StringProcessor.match_student_id(tmp));
        
        //System.out.println(StringProcessor.format_camel(tmp));
        MyString m1 = new MyString();
        //System.out.println(m1.f1(tmp));
        //System.out.println(m1.f2(tmp));
        System.out.println(m1.f2(tmp));
    }
    
}
