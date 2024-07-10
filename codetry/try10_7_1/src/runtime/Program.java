package runtime;

import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phone id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter phone name: ");
        String namephone = sc.nextLine();
        System.out.println("Enter unit price: ");
        double unit = Double.parseDouble(sc.nextLine());
        System.out.println("Enter quantity: ");
        int quantiti = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Status: ");
        boolean statu = sc.nextBoolean();
        Phone p1 = new Phone(id, namephone, unit, quantiti, statu);
        System.out.println(p1.subTotal());
    }
    
}
