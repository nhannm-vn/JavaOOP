/*
StudentV2: là cái khuôn đúc ra những thằng sinh viên có tính đố kỵ

Comparable: tính đố kỵ: hội những người thích đố kỵ và so sánh với người khác
Comparable: là một interface có một method tên là compareTo()(chủ động)
 */
package data;

public class StudentV2 implements Comparable<StudentV2>{
    private String id;
    private String fname;
    private String lname;
    private double score;
    
    //constructor

    public StudentV2(String id, String fname, String lname, double score) {
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

    @Override
    public int compareTo(StudentV2 that) {//một thằng này so với that
        if(this.getId().compareTo(that.getId()) > 0){
            return 1;//swap
        }else{
            return -1;
        }
    }
}
