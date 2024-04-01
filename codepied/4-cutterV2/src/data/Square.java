package data;
//class của hình vuông
public class Square extends Rectangle{

    public Square(double edge, String color) {
        super(edge, edge, color);
    }//chế phễu
    
    @Override
    public void showInFor(){
        String str = String.format("Square: %s|%.2f|%.2f|%.2f|%.2f"
        ,color , edgeA, edgeB, perimeter(), area());
        System.out.println(str);
    }
    
}
