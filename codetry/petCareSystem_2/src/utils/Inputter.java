/*
Inputter là một cái class chứa các công cụ nhập 

 */
package utils;

import java.util.Scanner;

public class Inputter {
    //tạo ra một cái Scanner dung chung luôn
    public static Scanner sc = new Scanner(System.in);
    
    //hàm nhập số nguyên chuẩn chỉnh
    public static int getInt(String inpMsg, String errMsg){
        System.out.println(inpMsg);//kêu người dùng nhập đi
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    //hàm nhập số nguyên chuẩn chỉnh + khoảng 
    public static int getInt(String inpMsg, String errMsg
                                        , int lowerBound, int upperBound){
        System.out.println(inpMsg);//kêu người dùng nhập đi
        if(lowerBound > upperBound){
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //hàm nhập số thực chuẩn chỉnh
    public static double getDouble(String inpMsg, String errMsg){
        System.out.println(inpMsg);//kêu người dùng nhập đi
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    //hàm nhập số thực chuẩn chỉnh + khoảng 
    public static double getDouble(String inpMsg, String errMsg
                                        , double lowerBound, double upperBound){
        System.out.println(inpMsg);//kêu người dùng nhập đi
        if(lowerBound > upperBound){
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //hàm nhập chuỗi chuẩn không bỏ trống
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
     public static String getString(String inpMsg, String errMsg, 
                                    String regex){
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
