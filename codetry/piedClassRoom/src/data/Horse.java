package data;

//class để quản lí những con ngựa hú hí

import java.util.Random;

public class Horse extends Herbivore{//nhận cha để thừa hưởng các đặc tính của cha
    //các con ngựa vì vừa học vừa hú hí nên khả năng học kém. Khả năng tiếp thu
    //tối đa của chúng chỉ là 30. Nhưng mà không phải con ngựa nào đều như vậy
    public static final double RECEPTIVE = 30;
    //con ngựa có thêm màu của cái yên nữa
    private String collorSaddle;
    
    //constructor
    //đổi cái của cha ưu tiên lên trước
    public Horse(String name, int yob, double weight, String collorSaddle) {
        super(name, yob, weight);
        this.collorSaddle = collorSaddle;
    }
    
    //method getter

    public String getCollorSaddle() {
        return collorSaddle;
    }
    
    //vá lại các lỗ thủng của cha Herbivore
    
    @Override
    public double study() {
        //tạo ra một cái random. Ta lấy các số thực từ 0 đến 1 rồi * với RECEPTIVE
        //(KHẢ NĂNG TIẾP THU) ta sẽ có được khả năng học của từng con <= 30
        return new Random().nextDouble() * RECEPTIVE;
    }

    @Override
    public void showLearningOutComes() { 
        //qua bên cha Herbivore mở protected để bên này thừa hưởng các biến
        String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|%-10s|"
                                    , "Horse", name, yob, weight, study(), collorSaddle);
        System.out.println(str);
    }
    
    
}
