package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input owner: ");
        String newOwner = sc.nextLine();
        System.out.println("Input weight: ");
        int newWeight = Integer.parseInt(sc.nextLine());
        Zebra z1 = new Zebra(newOwner, newWeight);
        System.out.println(z1.getOwner());
        System.out.println("Enter new weight: ");
        int wewew = Integer.parseInt(sc.nextLine());
        z1.setWeight(wewew);
        System.out.println(z1.getWeight());
    }
}
