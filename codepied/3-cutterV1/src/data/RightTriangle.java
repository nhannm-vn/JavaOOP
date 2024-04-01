package data;

public class RightTriangle extends Triangle{
    //viết lại phễu
    public RightTriangle(double edge1, double edge2) {
        super(edge1, edge2, Math.sqrt(edge1 * edge1 + edge2 * edge2));
    }
    
    //độ lại method
    @Override
    public void showInFor(){
        String str = String.format("RightTriangle: %.2f|%.2f|%.2f|%.2f|%.2f|"
                , edge1, edge2, edge3, perimeter(), area());
        System.out.println(str);
    }
    
}
