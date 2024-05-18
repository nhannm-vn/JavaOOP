package utils;

import java.util.Scanner;

/*
utils là cái hộp chứa các công cụ tiện ích
+Ta sẽ tạo ra class Inputter nhằm chứa các method nhập. Vì nếu ta để hết trong main
thì rất xấu
+Inputter vì ta lấy Inputter. trực tiếp để xài method nên ta phải static là tĩnh 
lặng chỉ tạo ra 1 cái duy nhất. Vì nếu k static thì ta tạo ra object mới sẽ tạo
ra nhiều method và không biết chỉ tới cái cụ thể nào.
+Đây là một cái khuôn không dùng để đúc ra object mà anh dùng class này để lưu
những hàm hỗ trợ cho việc nhập


*/
public class Inputter {
    //tại sao làm hàm phải static
    //nếu hàm bthg có khả năng bị phân mảnh. Vì nếu ta k để static nó sẽ hiểu
    //class tạo ra object nên tạo ra nhiều phiên bản và không biết chọn phiên bản
    //của thằng nào
    //static chỉ cố định thế nên Inputter mới biết mà . vô được
    
    //tạo Scanner một lần xài luôn nên để public
    public static Scanner sc = new Scanner(System.in);
    
    //những method hỗ trợ cho việc nhập
    //method ép người dùng nhập số nguyên chuẩn
    public static int getAnInteger(String inpMsg, String errMsg){
        System.out.println(inpMsg);//mời người dùng nhập số nguyên, chửi nếu nhập sai
        //nếu nhập đúng thì ném ra số đó, k thì lặp hoài
        while(true){
            try {
                /*
                Vì sao ta phải sc.nextLine() mà k phải nextInt() là vì khi nhập
                sai 12a sẽ nhập vào số 12 mà trôi a dẫn tới k phát ra lỗi để try-catch
                còn khi 12a nextLine() ép kiểu nó mới báo sai 
                */
                int number = Integer.parseInt(sc.nextLine());//ép tất cả về chuỗi
                return number;
            } catch (Exception e) {//nhập thất bại thì xuống đây
                System.out.println(errMsg);//nếu nhập thất bại thì chửi
            }
        } 
    }
    
    //method ép người dùng nhập số nguyên chuẩn nhưng nằm trong khoảng cố định
    //Overload: giống tên biến nhưng khác nhau parameter truyền vào và khác cách xài
    public static int getAnInteger(String inpMsg, String errMsg
                                    , int lowerBound, int upperBound){
        System.out.println(inpMsg);//mời người dùng nhập
        //trường hợp lowerBound > upperBound
        while(true){
                if(lowerBound > upperBound){
                int tmp = lowerBound;
                lowerBound = upperBound;
                upperBound = tmp;
            }
            try {
                int number = Integer.parseInt(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();//ném ra một lỗi lập tức sẽ xuống catch
                }
                //nếu k bị gì thì trả ra số
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //method ép người dùng nhập số thực chuẩn
    //dùng double cho dễ xài vì trong java lấy thực là double
    public static double getADouble(String inpMsg, String errMsg){
        System.out.println(inpMsg);//mời nhập vào
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;//nếu đúng thì trả ra luôn số
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    public static double getADouble(String inpMsg, String errMsg
                                    , double lowerBound, double upperBound){
        System.out.println(inpMsg);//mời người dùng nhập
        //trường hợp lowerBound > upperBound
        while(true){
                if(lowerBound > upperBound){
                double tmp = lowerBound;
                lowerBound = upperBound;
                upperBound = tmp;
            }
            try {
                double number = Double.parseDouble(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();//ném ra một lỗi lập tức sẽ xuống catch
                }
                //nếu k bị gì thì trả ra số
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //hàm nhập string không được bỏ trống
    public static String getString(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if(str.isEmpty()){//nếu trống thì quăng ra lỗi
                    throw new Exception();
                }
                return str;//không trống thì trả ra chuỗi và dừng
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    //hàm nhập string không được bỏ trống và phải đúng format theo regex
    public static String getString(String inpMsg, String errMsg,
                                    String regex){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if(str.isEmpty() || !str.matches(regex)){//nếu trống hoặc k đúng thì quăng ra lỗi
                    throw new Exception();
                }
                return str;//không trống thì trả ra chuỗi và dừng
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
}
