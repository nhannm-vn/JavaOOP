package runtime;

import data.SpecCar;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String keyName = sc.nextLine();
        System.out.println("Enter price: ");
        double keyPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Enter warranty: ");
        int keyWarranty = Integer.parseInt(sc.nextLine());
        SpecCar s1 = new SpecCar(keyName, keyPrice, keyWarranty);
        menu();
        int choice;
        choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:{
                System.out.println("OUTPUT:");
                System.out.println(s1.toString());
                break;
            }
            case 2:{
                System.out.println("OUTPUT:");
                System.out.println(s1.getName());
                break;
            }
            case 3:{
                System.out.println("OUTPUT:");
                System.out.println(s1.getWarranty());
                break;
            }
        }
    }
    public static void menu(){
        System.out.println("1. Test toString()");
        System.out.println("2. Test getName()");
        System.out.println("3. Test getWarranty()");
        System.out.println("Enter TC (1,2,3): ");
    }
}
