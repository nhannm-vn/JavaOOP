package data;
//class Herbivore: các động vật hoang dã, ăn cỏ
public abstract class Herbivore {
    //props mà con vật nào cũng phải có
    protected String name;
    protected int yob;
    protected double weight;
    
    //constructor

    public Herbivore(String name, int yob, double weight) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
    }
    
    //method getter

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getWeight() {
        return weight;
    }
    
    //method showInfor(): thay vì sử dụng nó thì ta chỉ in ra được nội dung đẹp
    /*
    +Trong java ta biết được tất cả mọi thứ đều coi Object là cha(thủy tổ). Nên khi
    ta lấy bất cứ class nào ta . cũng ra được một loạt các hàm của object
    +Ta biết được trong object có hàm toString()
    ==> vừa giúp in đẹp mà ta có thể nắm cái chuỗi trả ra để sử dụng
    +Nhờ vào việc object là thủy tổ là cha của tất cả các class. Ta có thể
    độ lại hàm toString của Object để xài
    */

    @Override
    public String toString() {
        String str = String.format("%-10s|%-20s|%4d|%7.2f|"
                                    , "Herbivore", name, yob, weight);
        return str;//trả ra chuỗi nè
    }
    
    //vì mỗi con có khả năng học khác nhau. Nên ta không thể nào định nghĩa cụ thể
    //con nào học ra sao. Ta chỉ có thể để là nó có method học nhưng phải để nó
    //tự định nghĩa
    /*
    Ví dụ: con ngựa vừa hú hí vừa học nên khả năng học kém
    */
    public abstract double study();
    
    //Mỗi con học khác nhau nên để nó tự báo khả năng học của nó:
    public abstract void showLearningOutComes();
    
}
