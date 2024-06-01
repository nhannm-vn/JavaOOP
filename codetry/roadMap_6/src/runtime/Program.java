/*
Bối cảnh: minh có một nhiệm vụ là phổ cạp kiến thức cho muôn loài 
Mình không dạy cho con chó con mèo bình thường nữa mà mình dạy cho những con hoang dã
ngày đầu tiên anh đến lớp gặp 2 con là ngựa và khỉ

=> muốn quản lí mấy con này thì phải dưa chúng về chung một mảng. Mà muốn như
vậy thì ta cần tìm ra các đặc điểm chung sau đó đưa cho cha giữ. Cha giữ rồi 
đưa lại cho mỗi thằng con. Nên ta có Herbivore là class đúc ra động vật ăn cỏ
 */
package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998, 210);
        Monkey m2 = new Monkey("Abu", 1994, 34);
        Horse h1 = new Horse("Rarity", 2015, 9, "None");
        Herbivore h2 = new Horse("Road", 2018, 1700, "Grey");
        //Khai cha new con thì đc. Có thể xài giống con ngựa nhưng phải ép kiểu
        //tạo mảng co giản để quản lí
        ArrayList<Herbivore> stuList = new ArrayList<>();
        stuList.add(m1);
        stuList.add(m2);
        stuList.add(h1);
        stuList.add(h2);
        //in ra kết quả học tập
        for (Herbivore item : stuList) {
            item.showLearningOutComes();
        }
        /*
        Trong lớp học của anh rớt vào một mùa đông giá rét. Mọi con vật đều co ro học
        tập trong cái lạnh. Thì bỗng nhiên có một con vật bé đi vào
        nó chùm kín mít nên mình k đoán đc nó là con gì. Thấy nó ăn cỏ, cũng hiền
        nên mình tin nó là một động vật ăn cỏ
        ==>Nó muốn xin học mình cần lưu nó vào danh sách thì làm sao
        */
        //Vừa vá vừa rót
        Herbivore xxx = new Herbivore("Con chậm chạp", 2004, 4) {
            @Override
            public double study() {
                return 80;//vì không ai chơi với mình nên học giỏi
            }
            
            @Override
            public void showLearningOutComes() {
                String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|"
                                    , "xxx", name, yob, weight, study());
                System.out.println(str);
            }
        };
        stuList.add(xxx);
        /*
        Lớp học đang yên lặng thì lại có thêm một bạn mới bước vào
        bạn này làm cả lớp học sôi động, đó là bác thợ săn
        bác đến vì bác ham hhocj
        muốn tham gia lớp hc này hãy lưu trữ bác thợ săn nhé
        */
        Hunter hun1 = new Hunter("Thợ săn vượn", 1999, 0, "Nỏ");
        Hunter hun2 = new Hunter("Mắt diều hâu", 0, 0, "Cung");
        
        hun1.showLearningOutComes();
        hun2.showLearningOutComes();
        //dù in mượt như thế nhưng mình không tài nào bỏ hun1 hun2 vào stuList đc
        //vì tụi nó không có dây mơ rễ má gì hết(stuList là mảng Herbivore)
        
    }
    
}
