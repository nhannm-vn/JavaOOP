/*
Class để đúc ra những con ngựa hú hí
 */
package data;

import java.util.Random;


public class Horse extends Herbivore{
    //Nhận cha để được thừa hưởng lại những gì mà đã đưa cho cha giữ
    //Các con ngựa vừa học vừa hú hí nên khả năng tiếp thu kém
    public static final int RECEPTIVE = 30;
    //con ngựa có thêm một thuộc tính nữa là màu của cái yên
    private String colorSaddle;
    
    //constructor

    public Horse(String name, int yob, double weight, String colorSaddle) {
        super(name, yob, weight);
        this.colorSaddle = colorSaddle;
    }
    
    //vá lỗ

    @Override
    public double study() {
        //Tạo ra một cái random
        Random random = new Random();//tạo ra một object random
        //ta lấy số thực từ 0 đến 1 * RECEPTIVE sẽ ra đc random từng thằng
        //mỗi thằng thông minh khác nhau <= 30
        return RECEPTIVE * random.nextDouble();
    }

    @Override
    public void showLearningOutComes() {
        //qua bên cha Herbivore mở protected để bên này thừa hưởng các biến
        String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|%-10s|"
                                    , "Horse", name, yob, weight, study(), colorSaddle);
        System.out.println(str);
    }
    
}
