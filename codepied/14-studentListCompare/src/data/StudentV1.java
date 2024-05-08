/*
StudentV1: là cái khuôn đúc ra các đối tượng sinh vien không hề có tính đố kỵ
hay sân si
 */
package data;

public class StudentV1 {
    private String id;
    private String fname;
    private String lname;
    private double score;
    
    //constructor

    public StudentV1(String id, String fname, String lname, double score) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.score = score;
    }
    
    //getter

    public String getId() {
        return id;
    }

    public double getScore() {
        return score;
    }
    
    //show
    public void showInfor(){
        String str = String.format("%-15s|%-15s|%-15s|%5.2f"
                                    , id, fname, lname, score);
        System.out.println(str);
    }
    
}
