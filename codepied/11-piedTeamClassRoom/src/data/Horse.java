package data;

import java.util.Random;

/*
khi mà Horse kế thừa Herbivore nó muốn?
+Kế thừa những gì cha nó đã có
+Khôi phục lại những gì đã đưa cho cha giữ
+Không cần làm lại những gì tiền bối đã làm tốt rồi
*/
public class Horse extends Herbivore{
    //props riêng
    private String colorSaddle;
    //con ngựa vừa học vừa hú hí nên khả năng tiếp thu của nó rất kém
    //mà con ngựa nào cũng vậy nên mình sẽ lưu khả năng tiếp thu cho tất cả con ngựa
    public static final double RECEPTIVE = 30;//khả năng tiếp thu tối đa
    
    //constructor
    //đưa thuộc tính của cha lên đầu
    public Horse(String name, int yob, double weight, String colorSaddle) {
        super(name, yob, weight);//new Horbivore
        //new Herbivore(name, yob, weight)
        this.colorSaddle = colorSaddle;
    }
    
    //không cần getter Receptive tại kia đã public rồi

    public String getColorSaddle() {
        return colorSaddle;
    }
    //mỗi con ngựa có khả năng tiếp thu tối đa là 30
    /*
    Mỗi con ngựa tuy học khác nhau. Nhưng khả năng tiếp thu tối đa là 30
    nhưng không phải con ngựa nào cũng 30 điểm, random lắm
    */

    @Override
    public double study() {
        //lấy một con số ngẫu nhiên kiểu thực từ 0 đến 1 đem nhân cho tối đa
        //sẽ ra được khả năng ngẫu nhiên
        return new Random().nextDouble() * RECEPTIVE;
    }

    @Override
    public void showLearningOutComes() {
        String str = String.format("%-20s|%-20s|%4d|%8.2f|%8.2f|%10s|",
                                    "Horse", name, yob, weight, study(), colorSaddle);
        System.out.println(str);
    }
    
}
