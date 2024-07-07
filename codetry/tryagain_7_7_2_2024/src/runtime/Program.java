package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter the String: ");
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        MyString m1 = new MyString();
        System.out.println(m1.f2(tmp));
    }
    
}
