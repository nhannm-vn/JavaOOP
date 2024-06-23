package data;

import java.util.Scanner;

public class StudentInIT extends Student{
    //prop rieng
    private int basic;
    private int specialzed;
    private int internship;
    
    //prop

    public StudentInIT() {
    }

    public StudentInIT(String rollNumber, String name, String phone
                        , int basic, int specialzed, int internship) {
        super(rollNumber, name, phone);
        this.basic = basic;
        this.specialzed = specialzed;
        this.internship = internship;
    }
    
    //getter and setter

    public int getBasic() {
        return basic;
    }

    public void setBasic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Basic score: ");
        int keyBasic = sc.nextInt();
        if(keyBasic < 0 || keyBasic > 10){
            System.out.println("Incorrect");
        }else{
            this.basic = keyBasic;
        }
    }

    public int getSpecialzed() {
        return specialzed;
    }

    public void setSpecialzed() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Specialzed score: ");
        int keySpecialzed = sc.nextInt();
        if(keySpecialzed < 0 || keySpecialzed > 10){
            System.out.println("Incorrect");
        }else{
            this.specialzed = keySpecialzed;
        }
    }

    public int getInternship() {
        return internship;
    }

    public void setInternship() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Internship score: ");
        int keyInternship = sc.nextInt();
        if(keyInternship < 0 || keyInternship > 10){
            System.out.println("Incorrect");
        }else{
            this.internship = keyInternship;
        }
    }

    @Override
    public double mediumScore() {
        return (double)(basic + specialzed + internship)/3;
    }

    @Override
    public String classification() {
        String key = null;
        if(mediumScore() >= 0 && mediumScore() < 5){
            key = "Week student";
        }else if(mediumScore() >= 5 && mediumScore() < 7){
            key = "Average academic";
        }else if(mediumScore() >= 7 && mediumScore() < 8.5){
            key = "Good academic";
        }else if(mediumScore() <= 8.5 && mediumScore() <= 10){
            key = "Excellent Student";
        }
        return key;
    }
    
    
}
