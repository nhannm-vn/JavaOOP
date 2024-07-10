package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter radius: ");
        Scanner sc = new Scanner(System.in);
        double tmp = Double.parseDouble(sc.nextLine());
        Circle c1 = new Circle(tmp);
        
        System.out.println(c1.toString());
    }
    
}
