/*
Inputter là một class chứa các method hỗ trợ cho việc nhập
Inputter là class để lưu trữ chứ k tạo ra đối tượng
 */
package utils;//package chứa các công cụ tiện ích

import java.util.Scanner;

public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    
    //method giúp nhập số nguyên chuẩn: chỉ nhận vào số nguyên nếu nhập sai thì nhập lại\
    //đến khi nào đúng thì thôi
    public static int getAnInteger(String inpMsg, String errMsg){
        //nói người dùng nhập
        System.out.println(inpMsg);
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
            /*
            nếu mà sc.nextIn() thì ví dụ nhập 12a ==> chỉ lưu 12 
            */
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }
    //method giúp nhập số nguyên chuẩn và nằm trong khoảng: chỉ nhận vào 
    //số nguyên và 2 khoảng nếu nhập sai thì nhập lại
    //đến khi nào đúng thì thôi
    public static int getAnInteger(String inpMsg, String errMsg ,
                                int lowerBound, int upperBound){
        //nói người dùng nhập
        System.out.println(inpMsg);
        if(lowerBound > upperBound){
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();//tạo ra cái lỗi mới
                }//nếu k nằm theo yêu cầu thì mình coi nó như là một lỗi
                //và ném lỗi đó ra ngoài
            /*
            nếu mà sc.nextIn() thì ví dụ nhập 12a ==> chỉ lưu 12 
            */
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }
    
    //method ép nhập số thực chuẩn, xài double cho dễ. Sai thì bắt nhập lại
    public static double getADouble(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }
    public static double getADouble(String inpMsg, String errMsg ,
                                double lowerBound, double upperBound){
        System.out.println(inpMsg);
        if(lowerBound > upperBound){
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                if(number < lowerBound || number > lowerBound){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }
    
    //nhập vào chuỗi nếu bỏ trống thì bắt nhập lại
    public static String getString(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if(str.isEmpty()){//nếu bỏ trống thì mình coi nó như lỗi
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
            
        }
    }
    
    //nhập chuỗi k bỏ trống và đúng với regex format
    public static String getString(String inpMsg, String errMsg, String regex){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if(str.isEmpty() || !str.matches(regex)){
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }
}
