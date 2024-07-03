package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        MyString m1 = new MyString();
        System.out.println(m1.f1(str));
        
    }
    
}
