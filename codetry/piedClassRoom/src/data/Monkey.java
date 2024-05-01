package data;
//class để quản lí những con khỉ(Monkey)

import java.util.Random;

public class Monkey extends Herbivore{
    //con khỉ không có props gì đặc biệt. Tuy nhiên khả năng tiếp thu làm theo của nó
    //tốt nên được cao hơn ngựa và không quá 70
    public static final double RECEPTIVE = 70;
    
    //constructor

    public Monkey(String name, int yob, double weight) {
        super(name, yob, weight);
    }
    
    //method vá khả năng học

    @Override
    public double study() {
        return new Random().nextDouble() * RECEPTIVE;
    }

    @Override
    public void showLearningOutComes() {
        String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|"
                                    , "Monkey", name, yob, weight, study());
        System.out.println(str);
    }
    
    
}
