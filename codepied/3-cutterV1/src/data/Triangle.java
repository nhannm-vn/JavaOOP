package data;

//Triangle là cái khuôn(class) chuyên dùng để đúc ra các bức tượng 
//tam giác(object)
//có thể nói rằng tất cả các hình tam giác đều được tạo ra từ cái khuôn này
public class Triangle {
    //tạo cái  ngăn
    protected double edgeA;//để private không ai lấy được giá trị nên phải cóget
    protected double edgeB;
    protected double edgeC;
    //double perimeter; //= edgeA + edgeB + edgeC; ==> sai do là cái ngăn
    /*
    Không nên tạo thuộc tính chu vi và diện tích
    +Nếu mình tạo ra nó thì người dùng có thể set giá trị lên nó và tất nhiên 
    có thể set sai so với 3 cạnh
    +Cái gì có thể tự tính được bằng những cái trước đó thì không nên lưu
    ==> vậy nên tạo một hàm tính chu vi, ai gọi thì mình lấy ba cạnh ra tính
    */
    //tạo cái phễu
    public Triangle(double edgeA, double edgeB, double edgeC) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }
   
    //method
    //getter

    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }
    
    public double getPerimeter(){
        return edgeA + edgeB + edgeC;
    }
    public double getArea(){
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - edgeA) * (p - edgeB) * (p - edgeC));
    }
    
    public void showInFor(){
        String str = String.format("Triangle: %.2f|%.2f|%.2f|%.2f|%.2f|"
                , edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
        //vừa sử dụng format in đẹp mà vừa xuống hàng được
        
    }
}
