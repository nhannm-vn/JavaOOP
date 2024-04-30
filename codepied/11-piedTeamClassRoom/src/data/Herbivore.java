package data;

//Herbivore: động vật ăn cỏ
public abstract class Herbivore {
    //props 
    protected String name;
    protected int yob;
    protected double weight;
    
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
    +thường để in thông tin ta xài hàm showInfor() để in ra được thông tin theo
    chuỗi đẹp. Ai gọi showInfor() thì không xài được chuỗi mà chỉ in ra thôi
    
    +trong java quy định vạn vật đều bắt đầu từ object nên khi vd: .h1 nó ra được
    các method của object. TẤT CẢ CÁC CLASS ĐỀU TỰ ĐỘNG NHẬN OBJECT LÀ CAO NHẤT
    
    +trong object có toString() tạo ra chuỗi đẹp, k in mà đưa cho mình tùy ý
    sử dụng. Nhờ vào sout ta có thể in ra được nó
    mình có thể sout(h1) mà không cần .toString()
    */
    
    //**Có nghĩa là khi ta muốn trả ra thông tin mà dưới dạng chuỗi thì ta độ
    //lại hàm toString của thủy tổ Object. Ta có thể cầm nó để biến đổi, để xài
    //chứ không chỉ là in ra như method showInfor()

    @Override
    public String toString() {//độ lại hàm toString() của thủy tổ object
        String str = String.format("%-20s|%-10s|%4d|%6.2f",
                                    "Herbivore", name, yob, weight);
        return str;//method trả ra String nên phải return str
    }
    
    //method study: một con vật học và trả ra điểm số
    //mỗi một Herbivore có mức độ tiếp thu kiến thức khác nhau
    //vì chúng có cách học khác nhau
    //vd: Ngựa vừa học vừa hú hí
    //    con khỉ là học kiểu bắt trước(mimic)
    //mỗi một con vật sẽ học khác nhau
    public abstract double study();//một cái lỗ thủng vì mỗi con sẽ học khác nhau
    
    //vì khả năng học của chúng khác nhau nên khi hiển thị kết quả học tập cũng khác nhau
    public abstract void showLearningOutComes();
    
}
