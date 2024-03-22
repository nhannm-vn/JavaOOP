
package runtime;

import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào họ và tên: ");
        String hoVaTen = sc.nextLine();
        System.out.println("Nhập vào điểm: ");
        int diem = sc.nextInt();
        System.out.println("--------------");
        System.out.println("Họ và tên la: " + hoVaTen);
        System.out.println("Điểm la: " + diem);
    }
}
