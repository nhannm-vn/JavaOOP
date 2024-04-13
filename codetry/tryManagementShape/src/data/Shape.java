package data;

public abstract class Shape {//vì có chứa hành động abstract ==> abstract luôn
    //thằng này sẽ mang tất cả đặc điểm chung của bọn kia
    protected String owner;
    protected String color;
    
    //cái phểu

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
    }
    
    //getter

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }
    
    //method
    public abstract double getPerimeter(); 
    // thằng này sẽ là abstract vì để cho mấy thằng kia định nghĩa riêng
    //nên nó k có body và không được đỉnh nghĩa
    public abstract double getArea();
    
    //paint in ra các thông tin
    public abstract void paint();

}
