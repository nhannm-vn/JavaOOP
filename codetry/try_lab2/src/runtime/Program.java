package runtime;

import data.Circle;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        double keyRadius;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius: ");
        keyRadius = Double.parseDouble(sc.nextLine());
        Circle c1 = new Circle(keyRadius);
        menu();
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:{
                c1.calculatePerimeter();
                System.out.printf("%4.2f\n", c1.getPerimeter());
                break;
            }
            case 2:{
                c1.calculateArea();
                System.out.printf("%4.2f\n", c1.getArea());
                break;
            }
            case 3:{
                c1.calculatePerimeter();
                c1.calculateArea();
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
