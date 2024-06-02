/*
Class để đúc ra những con ngựa hú hí
Horse tham gia hội StudyEnthusiasts thì sẽ được gì?
Horse sẽ không thừa hưởng được thuộc tính nào cả
(Fan thuộc về class StudyEnthusiasts) k mang đc về chỉ đc xài thôi
Horse sẽ nhận đc 2 cái lỗ(abstract method) và phải vá implement

class mà kế thừa class(prop method, override) extends
class mà chơi với interface (override) implement

**Một class chỉ có thể nhận 1 class khác làm cha, nhưng có thể tham gia nhiều hội
 */
package data;

import java.util.Random;


public class Horse extends Herbivore implements StudyEnthusiasts{
    //Nhận cha để được thừa hưởng lại những gì mà đã đưa cho cha giữ
    //Các con ngựa vừa học vừa hú hí nên khả năng tiếp thu kém
    public static final int RECEPTIVE = 30;
    //con ngựa có thêm một thuộc tính nữa là màu của cái yên
    private String colorSaddle;
    
    //constructor

    public Horse(String name, int yob, double weight, String colorSaddle) {
        super(name, yob, weight);
        this.colorSaddle = colorSaddle;
    }
    
    //vá lỗ

    @Override
    public double study() {
        //Tạo ra một cái random
        Random random = new Random();//tạo ra một object random
        //ta lấy số thực từ 0 đến 1 * RECEPTIVE sẽ ra đc random từng thằng
        //mỗi thằng thông minh khác nhau <= 30
        return RECEPTIVE * random.nextDouble();
    }

    @Override
    public void showLearningOutComes() {
        //qua bên cha Herbivore mở protected để bên này thừa hưởng các biến
        String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|%-10s|"
                                    , "Horse", name, yob, weight, study(), colorSaddle);
        System.out.println(str);
    }

    @Override
    public double studyHard() {
        return study() * 2.5;
    }

    @Override
    public void showProfile() {
        String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|%-10s|"
                                    , "Horse", name, yob, weight, studyHard(), colorSaddle);
        System.out.println(str);
    }
    
}
