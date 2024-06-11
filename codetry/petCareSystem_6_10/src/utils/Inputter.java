/*
utils là cái hộp chứa các công cụ tiện ích
    Inputter là một class chứa các method để nhập chuẩn chứ không tạo ra 
    đối tượng
 */
package utils;

import java.util.Scanner;

public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    //ham nhap so nguyen chuan
    public static int getInt(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){//sai thi bat nhap lai den dung
            try {//nem ra duoc loi
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    public static int getInt(String inpMsg, String errMsg
                                , int lowBow, int upBow){
        System.out.println(inpMsg);
        if(lowBow > upBow){
            int tmp = lowBow;
            lowBow = upBow;
            upBow = tmp;
        }
        while(true){//sai thi bat nhap lai den dung
            try {//nem ra duoc loi
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
    
    public static double getDouble(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){//sai thi bat nhap lai den dung
            try {//nem ra duoc loi
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    public static double getDouble(String inpMsg, String errMsg
                                , double lowBow, double upBow){
        System.out.println(inpMsg);
        if(lowBow > upBow){
            double tmp = lowBow;
            lowBow = upBow;
            upBow = tmp;
        }
        while(true){//sai thi bat nhap lai den dung
            try {//nem ra duoc loi
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
    
    public static String getString(String inpMsg, String errMsg
                            , String regex){
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
