package data;
//khuôn để đúc ra những con khỉ
//vì con khỉ có khả năng bắt trước(mimi) cao nên RECEPTIVE cao 

import java.util.Random;

public class Monkey extends Herbivore {
    public static final double RECEPTIVE = 70;//khả năng tiếp thu cao
    //không có các props riêng
    //constructor

    public Monkey(String name, int yob, double weight) {
        super(name, yob, weight);
    }
    
    //không có getter
    //vá các lỗ thủng
    @Override
    public double study() {
         return new Random().nextDouble() * RECEPTIVE;
    }

    @Override
    public void showLearningOutComes() {
        String str = String.format("%-20s|%-20s|%4d|%8.2f|%8.2f|",
                                    "Monkey", name, yob, weight, study());
        System.out.println(str);
    }
    
    
    
}
