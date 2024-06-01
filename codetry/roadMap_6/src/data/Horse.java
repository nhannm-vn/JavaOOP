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
        return RECEPTIVE * random.nextDouble();
    }

    @Override
    public void showLearningOutComes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
