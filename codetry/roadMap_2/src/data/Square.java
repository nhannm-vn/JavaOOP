/*
nhận Rectangle làm cha vì hình vuông cũng là hcn
 */
package data;

public class Square extends Rectangle{
    //cái phểu
    public Square(String color, double edge) {
        super(color, edge, edge);
    }
    
    //độ lại hàm paint của cha
    @Override
    public void paint(){
        String str = String.format("%s|%10s|%5.2f|%5.2f|%5.2f|%5.2f"
                                    , "Square", color, height, width, getPerimeter(), getArea());
        System.out.println(str);
    }
}
