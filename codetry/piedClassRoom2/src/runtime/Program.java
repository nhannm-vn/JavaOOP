package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import data.StudyEnthusiasts;
import java.util.ArrayList;

/*
Herbivore có trước?
==> Sai, nó có sau. Nó có để giúp ngựa và khỉ có thể về chung một nhà
Đem 2 thằng ngựa và khỉ ra nó đều ăn cỏ, đều học, đều in thông tin. Nên 
ta lấy đó ra làm thành một thằng Herbivore chung để quản lí

Nếu muốn nhét Hunter vào mảng thì cho Hunter extends Herbivore hoặc Monkey
Code vẫn chạy bthg. Nhưng bọn nó không phù hợp về mặt nhận thức

**Horse và Monkey có props và method giống nhau nên đưa về class chung đc
**Còn Hunter chỉ giống nhau về method nên chỉ vô chung hội chứ k có liên quan gì 
tới cha con
==>interface: giao tiếp(mối quan hệ xã giao)
cái cớ bịa ra để vào chung hội
==>Mối quan hệ không bền, rất là mỏng manh

*/
public class Program {
    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998, 210);
        Monkey m2 = new Monkey("Abu", 1994, 30);
        Horse h1 = new Horse("Rarity", 2015, 9, "none");
        Herbivore h2 = new Horse("Road", 2019, 1700, "Grey");
        Hunter hun1 = new Hunter("Thợ săn vượn", 1999, 64, "Nỏ");
        
        //tạo ra mảng chưa người tham học
        ArrayList<StudyEnthusiasts> stuList = new ArrayList<>();
        stuList.add(h1);
        //stuList.add(h2); không add đc vì đang có danh xưng là đv ăn cỏ
        //nên ta có thể ép kiểu để nhét nó vào
        stuList.add((Horse)h2);
        
        //hôm nay mọi người đều học chăm chỉ thì có một con lười(Sloth) đến học
        //tưởng là một học sinh mới hóa ra chính là cái con đã chùm kín mít
        //anh muốn lưu con lười thì phải làm sao
        //1. tạo con lười bằng class Herbivore như lần trước thông qua anonymous
        //thì không nhét vào stuList đc vì stuList là hội ham học
        
        //2. tạo class tên là Sloth và cho Sloth implements StudyEnthusiasts
        //nếu viết code thì bthg. Nhưng lười mà ham học thì kỳ lắm
        //đâu phải con lười nào cũng ham học đâu
        //mình code như này là mình ép tất cả lười trên thế giới đều ham học
        
        //con lười của mình là một con lười rất đặc biệt so với giống loài của nó
        //nên mình không nên xem nó và một con lười bthg mà nên xem nó là một loài
        //đặc biệt ham học
        //==> giải pháp 
        //3.Tạo con lười bằng anonymous thông qua StudyEnthusiasts
        StudyEnthusiasts xxx = new StudyEnthusiasts() {
            @Override
            public double studyHard() {
                return 80 * 1.5;
            }

            @Override
            public void showProfile() {
                String str = String.format("%-20s|%-20s|%4d|%6.2f|%6.2f"//LƯU Ý KHI TRUYỀN THẰNG 1 SỐ VÀO THÌ PHẢI CÓ F
                                            , "SlothSpe", "Flash", 1999, 120F, studyHard());
                System.out.println(str);//nếu một số thực bthg là double mà %f nên là phải ép F
            }
        };
        stuList.add(xxx);
    }
    
}
