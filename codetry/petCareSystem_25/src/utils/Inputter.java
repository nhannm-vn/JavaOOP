/*
utils là cái hộp chứa những công cụ tiện ích
Inputter là cái class chứa các công cụ để nhập

 */
package utils;

import java.util.Scanner;

public class Inputter {
    //tạo 1 lần Scanner xài cả đời
    public static Scanner sc = new Scanner(System.in);
    //nhập số nguyên chuẩn
    public static int getInteger(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        int number;
        while(true){
            try {
                number = Integer.parseInt(sc.nextLine());//ép tất cả về số nguyên
                //nếu đúng thì trả ra số number
                return number;
            } catch (Exception e) {
                //nếu có lỗi thì báo
                System.out.println(errMsg);
            }
        }
    }
    
    //nhập số nguyên trong khoảng
    //overload
    public static int getInteger(String inpMsg, String errMsg
                                , int lowerBound, int upperBound){
        System.out.println(inpMsg);
        int number;
        if(lowerBound > upperBound){
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while(true){
            try {
                number = Integer.parseInt(sc.nextLine());//ép tất cả về số nguyên
                //nếu đúng thì trả ra số number
                if(number < lowerBound || number > upperBound){
                    //tạo ra lỗi
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                //nếu có lỗi thì báo
                System.out.println(errMsg);
            }
        }
    }
    //nhập số thực chuẩn
    public static double getDouble(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        double number;
        while(true){
            try {
                number = Double.parseDouble(sc.nextLine());//ép tất cả về số nguyên
                //nếu đúng thì trả ra số number
                return number;
            } catch (Exception e) {
                //nếu có lỗi thì báo
                System.out.println(errMsg);
            }
        }
    }
    
    //nhập số nguyên trong khoảng
    //overload
    public static double getDouble(String inpMsg, String errMsg
                                , double lowerBound, double upperBound){
        System.out.println(inpMsg);
        double number;
        if(lowerBound > upperBound){
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while(true){
            try {
                number = Double.parseDouble(sc.nextLine());//ép tất cả về số nguyên
                //nếu đúng thì trả ra số number
                if(number < lowerBound || number > upperBound){
                    //tạo ra lỗi
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                //nếu có lỗi thì báo
                System.out.println(errMsg);
            }
        }
    }
    
    //Nhập chuỗi k bỏ trống
    public static String getString(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        String str;
        while(true){
            try {
                str = sc.nextLine();
                if(str.isEmpty()){
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    //nhập chuỗi k bỏ trống và đúng format
    public static String getString(String inpMsg, String errMsg, String regex){
        System.out.println(inpMsg);
        String str;
        while(true){
            try {
                str = sc.nextLine();
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
