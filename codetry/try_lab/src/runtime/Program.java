package runtime;

import data.Laptop;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input price: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("Input memory: ");
        int memory = Integer.parseInt(sc.nextLine());
        
        Laptop l1 = new Laptop(name, price, memory);
        
        int choice;
        showMenu();
        choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:{
                System.out.println(l1.toString());
                break;
            }
            case 2:{
                l1.updateYear();
                System.out.println(l1.getName());
                break;
            }
            case 3:{
                System.out.println(l1.getCategory());
                break;
            }
            default:{
                System.out.println("Lua chon tu 1 den 3");
            }
        }
        
        
        
    }
    public static void showMenu(){
        System.out.println("1.Test toString()");
        System.out.println("2.Test updateYear()");
        System.out.println("3.Test getCategory()");
        System.out.println("Enter TC(1,2,3): ");
    }
    
}
