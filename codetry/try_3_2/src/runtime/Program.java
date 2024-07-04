package runtime;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        //System.out.println(StringProcessor.match_student_id(tmp));
        System.out.println(StringProcessor.format_camel(tmp));
    }
    
}
