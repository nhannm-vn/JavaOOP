/*
Class lưu trữ bác thợ săn
 */
package data;

import java.util.Random;

public class Hunter {
    //props của bác thợ săn
    private String name;
    private int yob;
    private double weight;
    public static final int RECEPTIVE = 50;
    //bác có thêm cây vũ khí
    private String gear;
    //constructor

    public Hunter(String name, int yob, double weight, String gear) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.gear = gear;
    }
    
    //method getter

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getWeight() {
        return weight;
    }

    public String getGear() {
        return gear;
    }
    //method học
    public double study(){
        return new Random().nextDouble() * RECEPTIVE;
    }
    //method show khả năng học
    
    public void showLearningOutComes(){
        String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|%-10s|"
                                    , "Hunter", name, yob, weight, study(), gear);
        System.out.println(str);
    }
    
    
}
