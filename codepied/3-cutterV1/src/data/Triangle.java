package data;

//Triangle là cái khuôn(class) chuyên dùng để đúc ra các bức tượng 
//tam giác(object)
//có thể nói rằng tất cả các hình tam giác đều được tạo ra từ cái khuôn này
public class Triangle {
    //tạo cái  ngăn
    protected double edge1;
    protected double edge2;
    protected double edge3;
    //double perimeter; //= edgeA + edgeB + edgeC; ==> sai do là cái ngăn
    /*
    Không nên tạo thuộc tính chu vi và diện tích
    +Nếu mình tạo ra nó thì người dùng có thể set giá trị lên nó và tất nhiên 
    có thể set sai so với 3 cạnh
    +Cái gì có thể tự tính được bằng những cái trước đó thì không nên lưu
    ==> vậy nên tạo một hàm tính chu vi, ai gọi thì mình lấy ba cạnh ra tính
    */
    //tạo cái phễu

    public Triangle(double edge1, double edge2, double edge3) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
    }
    //method
    //getter
    public double getEdge1() {
        return edge1;
    }

    public double getEdge2() {
        return edge2;
    }

    public double getEdge3() {
        return edge3;
    }
    
    public double perimeter(){
        return edge1 + edge2 + edge3;
    }
    public double area(){
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - edge1) * (p - edge2) * (p - edge3));
    }
    
    public void showInFor(){
        String str = String.format("Triangle: %.2f|%.2f|%.2f|%.2f|%.2f|", edge1
        , edge2, edge3, perimeter(), area());
        System.out.println(str);
    }
}
