package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("Enter a number:");
        int num = Integer.parseInt(sc.nextLine());
        
        System.out.println(m1.sumNumber(num));
        */
        MyUtilities m1 = new MyUtilities();
        System.out.println("Enter a sentence:");
        String seten = sc.nextLine();
        System.out.println("Enter s1:");
        String s1 = sc.nextLine();
        System.out.println("Enter s2:");
        String s2 = sc.nextLine();
        System.out.println(m1.replaceString(seten, s1, s2));
    }
    
}
