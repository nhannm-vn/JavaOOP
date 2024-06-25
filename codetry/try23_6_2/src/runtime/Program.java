package runtime;

import data.StudentInIT;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter role: ");
        String keyRole = sc.nextLine();
        System.out.println("Enter name: ");
        String keyName = sc.nextLine();
        System.out.println("Enter phone: ");
        String keyPhone = sc.nextLine();
        System.out.println("Enter basic subject: ");
        int keyBasic = Integer.parseInt(sc.nextLine());
        System.out.println("Enter specialized subject");
        int keySpecialized = Integer.parseInt(sc.nextLine());
        System.out.println("Enter internship subject: ");
        int keyInternship = Integer.parseInt(sc.nextLine());
        StudentInIT s1 = new StudentInIT(keyName, keyRole, keyPhone, keyBasic, keySpecialized, keyInternship);
        menu();
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:{
                System.out.println("OUTPUT:");
                System.out.printf("%2.2f", s1.mediumScore());
                break;
            }
            case 2:{
                System.out.println("OUTPUT:");
                System.out.println(s1.classification());
                break;
            }
            case 3:{
                s1.setBasic();
                System.out.println("OUTPUT:");
                System.out.println(s1.getBasic());
                break;
            }
            case 4:{
                s1.setSpecialzed();
                System.out.println("OUTPUT:");
                System.out.println(s1.getSpecialzed());
                break;
            }
            case 5:{
                s1.setInternship();
                System.out.println("OUTPUT:");
                System.out.println(s1.getInternship());
                break;
            }
            case 6:{
                System.out.println("OUTPUT:");
                System.out.println(s1.toString());
                break;
            }
        }
        
        
        
    }
    public static void menu(){
        System.out.println("1.Test mediumScore()");
        System.out.println("2.Test classification()");
        System.out.println("3.Test setBasic()");
        System.out.println("4.Test setSpecialized()");
        System.out.println("5.Test setInternship()");
        System.out.println("6.Test student");
        System.out.println("Enter TC: ");
    }
}
