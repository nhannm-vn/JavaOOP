/*
RightTriangle là cái khuôn chuyên dùng để đúc ra các tam giác vuông. Tuy nhiên vì 
nó cũng là một tam giác nên nó có thể nhận thằng Triangle là tam giác
 */
package data;

public class RightTriangle extends Triangle{
    //thừa hưởng hết tất cả những gì mà Triangle có

    public RightTriangle(double edgeA, double edgeB) {//nhận vào bên main truyền 2 thuộc tính thoi
        super(edgeA, edgeB, Math.sqrt(Math.pow(edgeA, 2) + Math.pow(edgeB, 2)));//super ám chỉ đến class của bề trên
        //gọi cái phểu của thằng cha ra
    }
    
    //Override lại hàm của thằng cha
    @Override
    //show thông tin ra
    public void showInfor(){
        String str = String.format("%s|%5.2f|%5.2f|%5.2f|%5.2f"
                        , "RightTriangle", edgeA, edgeB, getPerimeter(), getArea());
        System.out.println(str);
    }
    
}
