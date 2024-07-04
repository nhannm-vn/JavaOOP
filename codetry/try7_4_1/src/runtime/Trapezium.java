package runtime;

public class Trapezium {
    private float firstEdge;
    private float secondEdge;
    private float height;

    public Trapezium() {
    }

    public Trapezium(float firstEdge, float secondEdge, float height) {
        this.firstEdge = firstEdge;
        this.secondEdge = secondEdge;
        this.height = height;
    }
    public float getAcreage(){
        float area = (firstEdge + secondEdge) * height / 2;
        String str = String.format("%.2f", area);
        return Float.parseFloat(str);
    }
    
    public String getInfo(){
        if(firstEdge != secondEdge){
            return "Regular trapezium";
        }else{
            return "Isosceles trapezium";
        }
    }
    
    public void setFirstEdge(float fe){
        if(fe > 0){
            this.firstEdge = fe;
        }else{
            System.out.println("Invalid value");
        }
        
    }
    public void setSecondEdge(float fe){
        if(fe > 0){
            this.secondEdge = fe;
        }else{
            System.out.println("Invalid value");
        }
    }
    
}
