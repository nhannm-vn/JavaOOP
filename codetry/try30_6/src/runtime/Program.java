package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter TC(1 or 2): ");
        int choice;
        Scanner sc = new Scanner(System.in);
        MyString m1 = new MyString();
        choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:{
                System.out.println("Enter a string: ");
                String str = sc.nextLine();
                System.out.println("OUTPUT: ");
                System.out.println(m1.f1(str));
                break;
            }
            case 2:{
                System.out.println("Enter a string: ");
                String str = sc.nextLine();
                System.out.println(m1.f2(str));
                break;
            }
        }
    }
    
}
