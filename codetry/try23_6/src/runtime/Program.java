package runtime;

import data.Circle;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double keyRadius = Double.parseDouble(sc.nextLine());
        Circle c1 = new Circle(keyRadius);
        
        int choice;
        menu();
        choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:{
                c1.caculatePerimeter();
                System.out.printf("%2.2f\n", c1.getPerimeter());
                break;
            }
            case 2:{
                c1.caculateArea();
                System.out.printf("%2.2f\n", c1.getArea());
                break;
            }
            case 3:{
                c1.caculatePerimeter();
                c1.caculateArea();
                System.out.println(c1.toString());
                break;
            }
        }
        
    }
    public static void menu(){
        System.out.println("1.Test calculatePerimeter()");
        System.out.println("2.Test calculateArea()");
        System.out.println("3.Test toString()");
        System.out.println("Enter TC(1/2/3):");
    }
}
