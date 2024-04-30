package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import java.util.ArrayList;

/*
bối cảnh: mình có một nhiệm vụ là phổ cập kiến thức cho muôn loài
mình không dạy cho con chó, con mèo bthg nữa. Mình dạy cho những con hoang dã
+ngày đầu tiên anh đến lớp anh đã gặp được 2 con vật rất dễ thương
đó là ngựa và khỉ
*/

//muốn quản lí cả ngựa và khỉ chúng ta có Herbivore(động vât ăn cỏ)

public class Program {
    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998, 210);
        Monkey m2 = new Monkey("Abu", 1994, 34);
        Horse h1 = new Horse("Rarity", 2015, 9, "None");
        Herbivore h2 = new Horse("Road", 2019, 1700, "Grey");
        //khai cha new con thì được. có thể xài giống con ngựa nhưng phải ép kiểu
        //tạo mảng kiểu primitive
        //Herbivore stuList[] = {m1, m2, h1, h2};không có tính co dãng
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
        
        //vừa đúc vừa rót giá trị: Anonymous
        Herbivore xxx = new Herbivore("Con chậm chạp", 2004, 4) {
            @Override
            public double study() {
                return 80;//vì chậm chạp không ai chơi nên chăm học
            }
            
            @Override
            public void showLearningOutComes() {
                String str = String.format("%-20s|%-20s|%4d|%8.2f|%8.2f|",
                                    "xxx", name, yob, weight, study());
                System.out.println(str);
            }
        };
        //thêm vào danh sách
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
