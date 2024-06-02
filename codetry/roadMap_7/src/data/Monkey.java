/*
Monkey là cái khuôn chuyên dùng để đúc ra những con khỉ
khỉ vì không dám di học vì sợ bác thợ săn nên k gia vào hội StudyEnthusiasts
vì sợ nên k đc hưởng 2 cái lỗ
 */
package data;

import java.util.Random;

public class Monkey extends Herbivore{
    //con khỉ không có prop gì đặc biệt. Tuy nhiên khả năng tiếp thu của nó cao hơn
    //con ngựa
    public static final int RECEPTIVE = 70;
    
    //constructor

    public Monkey(String name, int yob, double weight) {
        super(name, yob, weight);
    }
    
    //vá lỗ

    @Override
    public double study() {
        Random random = new Random();
        return RECEPTIVE * random.nextDouble();
    }

    @Override
    public void showLearningOutComes() {
        String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|"
                                    , "Monkey", name, yob, weight, study());
        System.out.println(str);
    }
    
}
