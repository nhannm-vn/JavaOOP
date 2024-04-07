package data;

//có hai hướng để giải quyết
public class Square extends Rectangle {
    // độ lại phễu

    //nơi nhận giá trị vào của th cha
    public Square(String owner, String color, double edge) {
        super(owner, color, edge, edge);//này cố định k thay đổi đc
    }
    
    // độ lại hàm riêng nếu có:
    @Override
    public void paint() {
        String str = String.format("Square:   %s|%s|%.2f|%.2f|%.2f|", owner, 
                color, height, getPerimeter(), getArea());
        //Không thể in ra thằng edge đc vì nó k đc khai báo trong class
        System.out.println(str);
    }
    
}
