package data;

public class Laptop extends Product{
    private int memory;
    
    //cosntructor

    public Laptop() {
    }

    public Laptop(String name, int price, int memory) {
        super(name, price);
        this.memory = memory;
    }

    @Override
    public String toString() {
        String str = String.format("%s,%d,%d"
                                , name, price, memory);
        return str;
    }
    
    public void updateYear(){
        setName(name + "_2023");
    }
    
    public int getCategory(){
        if(memory > 8){
            return 1;
        }else{
            return 2;
        }
    }
    
}
