/*
utils là cái hộp chứa những công cụ tiện tích
Inputter là một anh giúp mình nhập chuẩn
 */
package utils;

import java.util.Scanner;

public class Inputter {
    /*
    Inputter là một anh giúp cho mình nhập chuẩn. Nhờ vào mà nhập
    */
    public static Scanner sc = new Scanner(System.in);
    
    //giup nhap so nguyen chuan
    public static int getInt(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    //giup nhap so nguyen chuan trong khoang lowBow upBow
    public static int getInt(String inpMsg, String errMsg
                            , int lowBow, int upBow){
        System.out.println(inpMsg);
        while(true){
            if(lowBow > upBow){
                int tmp = lowBow;
                lowBow = upBow;
                upBow = tmp;
            }
            try {
                int number = Integer.parseInt(sc.nextLine());
                if(number < lowBow || number > upBow){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //giup nhap so thuc chuan
    public static double getDouble(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    //giup nhap so thuc chuan trong khoang lowBow upBow
    public static double getDouble(String inpMsg, String errMsg
                            , double lowBow, double upBow){
        System.out.println(inpMsg);
        while(true){
            if(lowBow > upBow){
                double tmp = lowBow;
                lowBow = upBow;
                upBow = tmp;
            }
            try {
                double number = Double.parseDouble(sc.nextLine());
                if(number < lowBow || number > upBow){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //nhap chuoi khong bo trong
    public static String getString(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if(str.isEmpty()){
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    //nhap chuoi khong bo trong hoac regex
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
                System.out.println(errMsg);
            }
        }
    }
}
