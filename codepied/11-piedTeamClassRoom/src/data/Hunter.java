package data;

import java.util.Random;

public class Hunter {
    //tạo ra các props riêng
    private String name;
    private int yob;
    private double weight;
    private String gear;
    //vì mãi mê nhìn phò mã nên khả năng tiếp thu của bác yếu
    public static final double RECEPTIVE = 50;
    
    //tạo constructor

    public Hunter(String name, int yob, double weight, String gear) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.gear = gear;
    }
    
    //method riêng
    public double study() {
         return new Random().nextDouble() * RECEPTIVE;
    }
    
    public void showLearningOutComes() {
        String str = String.format("%-20s|%-20s|%4d|%8.2f|%8.2f|%10s|",
                                    "Hunter", name, yob, weight, study(), gear);
        System.out.println(str);
    }
}
