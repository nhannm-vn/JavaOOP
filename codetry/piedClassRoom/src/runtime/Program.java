package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import java.util.ArrayList;

/*
**Bối cảnh: mình có một nhiệm vụ là mình phổ cập kiến thức cho muôn loài
mình không dạy con chó, con mèo bthg nữa mà mình dạy đv hoang dã
**Ngày đầu tiên anh đến lớp anh gặp hai con vật rất dễ thương là khỉ và ngựa
*/
//Muốn đưa chúng về cùng một mảng để quản lí thì cần tìm ra các đặc điểm chung của
//chúng rồi cho chúng đưa các thuộc tính cho class cha rồi lúc sau nhận và thừa hưởng

public class Program {
    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998, 210);
        Monkey m2 = new Monkey("Abu", 1994, 34);
        Horse h1 = new Horse("Rarity", 2015, 9, "None");
        Herbivore h2 = new Horse("Road", 2019, 1700, "Grey");
        //khai cha new con thì được. có thể xài giống con ngựa nhưng phải ép kiểu
        //tạo mảng kiểu primitive
        //Herbivore stuList[] = {m1, m2, h1, h2};không có tính co dãng
        
        //tạo ra cái mảng co dãng để quản lí các con vật
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
        Lớp học của anh rớt vào một mùa đông giá rét. Mọi con vật đều co ro học
        tập trong cái lạnh. Thì bỗng nhiên có một con vật nhỏ bé đi vào
        nó chùm kính mít và vì quá kính nên mình không đoán được nó là con gì
        . Thấy nó ăn cỏ, cũng hiền nên mình tin nó là một động vật ăn cỏ
        ==> nó muốn xin học mình cần lưu nó vào ds thì làm sao?
        */
        //vừa vá vừa rót
        Herbivore xxx = new Herbivore("Con chậm chạp", 2004, 4) {
            @Override
            public double study() {
                return 80;//vì ko ai chơi nên hc giỏi
            }
            
            @Override
            public void showLearningOutComes() {
                String str = String.format("%-10s|%-30s|%4d|%8.2f|%8.2f|"
                                    , "xxx", name, yob, weight, study());
                System.out.println(str);
            }
        };
        
        stuList.add(xxx);
        //Lớp học đang yên lặng thì lại có thêm một bạn mới vào
        //bạn này làm cả lớp học sôi động, đó là bác thợ săn
        //bác đến vì bác ham học
        //muốn tham gia vào lớp học hãy lưu trữ bác thợ săn nhé
        
        //tạo ra bác thợ săn
        Hunter hun1 = new Hunter("Thợ săn vượn", 1999, 0, "Nỏ");
        Hunter hun2 = new Hunter("Mắt diều hâu", 1999, 0, "Cung");
        
        hun1.showLearningOutComes();
        hun2.showLearningOutComes();
        //dù in mượt như thế nhưng mình không tài nào bỏ hun1 hun2 vào stuList đc
        //vì tụi nó không có dây mơ rễ má gì hết(stuList là mảng Herbivore)
    }
    
}
