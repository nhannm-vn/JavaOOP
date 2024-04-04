package data;
//Class đúc ra tam giac vuông
public class RightTriangle extends Triangle {
    //tạo cái phễu
    //cạnh 3 này tự tính luôn. Nhận vào 2 cạnh thôi sợ người đùng nhập bậy
    public RightTriangle(double edgeA, double edgeB) {
        super(edgeA, edgeB, Math.sqrt(edgeA * edgeA + edgeB * edgeB));
    }
    
    //độ lại hàm
    @Override
    public void paint(){
        String str = String.format("RightTriangle: %.2f|%.2f|%.2f|%.2f|%.2f",
                edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
    }
    
}
