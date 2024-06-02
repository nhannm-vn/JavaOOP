/*
Herbivore có trước?
==>Sai, nó có sau. Nó có để giúp ngựa và khỉ có thể về chung một nhà
đem 2 thằng ngựa và khỉ ra nó đều ăn cỏ, đều học, đều in thông tin. Nên 
ta lấy đó ra làm thành một thằng Herbivore chung để quản lí

Nếu muốn nhét Hunter vào mảng thì cho Hunter extends Herbivore hoặc Monkey
Code vẫn chạy bthg. Nhưng bọn nó không phù hợp về mặt nhận thức

**Horse và Monkey có props và method giống nhau nên đưa về chung đc
**Còn Hunter chỉ giống nhau về method nên chỉ vô chung hội chứ k có liên quan gì đến
cha con
==>interface: giao tiếp(mối quan hệ xã giao)
cái cớ bịa ra để chung hội
==>Mối quan hệ để vào chung hội
==>Mối quan hệ không bền, rất là mỏng manh
 */
package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import data.StudyEnthusiasts;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998, 210);
        Monkey m2 = new Monkey("Abu", 1994, 30);
        Horse h1 = new Horse("Rafity", 2015, 9, "None");
        Herbivore h2 = new Horse("Road", 2019, 1700, "Grey");
        Hunter hun1 = new Hunter("Thợ săn vượn", 1994, 64, "Nỏ");
        
        //tạo ra mảng chưa người ham học
        ArrayList<StudyEnthusiasts> stuList = new ArrayList<>();
        stuList.add(h1);
        //stuList.add(h2) không add được vì đang có danh xưng là động vật ăn cỏ
        //nên ta cần ép kiểu để nhét nó vào
        stuList.add((Horse)h2);
        //hôm nay nội người đều chăm chỉ hc thì có một con lười (Sloth) đến học
        //tưởng là một học sinh mới hóa ra chính là cái con chùm kín mít
        //anh muốn lưu con lười thì phải làm sao
        //1.tạo con lười bằng class Herbivore như lần trước thông qua anonymous
        //thì không nhét vào stuList được vè stuList là hội ham học
        
        //2.tạo class tên là Sloth cho Sloth implements StudyEnthusias 
        //Nếu viết code thì bthg nhưng lười mà ham học thì kỳ lắm
        //đâu phải con lười nào cũng ham học đâu
        
        //con lười của mình là một con lười đặc biệt so với giống loài của nó 
        //nên mình không nên xem nó là một con lười btgh mà nên xem nó là một loài
        //đặc biệt ham học
        //=>giải pháp
        //3.tạo con lười bằng anonymous thông qua StudyEnthusiasts
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
