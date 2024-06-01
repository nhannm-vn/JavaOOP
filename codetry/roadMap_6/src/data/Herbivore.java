package data;
//class Herbivore đúc ra các động vật hoang dã
public abstract class Herbivore {
    //props mà con vật nào cũng phải có
    private String name;
    private int yob;
    private double weight;
    
    //constructor

    public Herbivore(String name, int yob, double weight) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
    }
    
    //getter

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getWeight() {
        return weight;
    }
    
    /*
    method showInfor(): nó chỉ giúp ta in ra được cái chuỗi đẹp chứ k đưa cho ta cái
    chuỗi để xài. 
    +Trong java ta được biết tất cả đều nhận Object là thủy tổ là đấng tối cao
    nên khi ta lấy bất cứ class nào ta chấm thì cũng đc một đống hàm của Object
    ==>Ta biết được trong object có hàm toString()
    ==>giúp vừa in được cái chuỗi đẹp mà vừa có thể nắm cái đó để xài
    +Nhờ vào việc Object là thủy tổ là cha của tất cả, ta có thể độ lại hàm để xài
    */

    @Override
    public String toString() {
        String str = String.format("%-10s|%-20s|%4d|%7.2f|"
                                    , "Herbivore", name, yob, weight);
        return str;
    }
    //Vì mỗi con có khả năng tự học khác nhau, nên ta không thể định chung. Phải
    //để bọn chúng tự định nghĩa cách học cưa riêng mình
    //mình biết là có method học nhưng học sao thì phải tự nó tính
    //ví dụ con ngựa vừa học vừa hú hí nên khả năng học kém
    public abstract double study();
    
    //show của mỗi thằng cũng khác nhau
    public abstract void showLearningOutComes();
}
