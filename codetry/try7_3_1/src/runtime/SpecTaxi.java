package runtime;

public class SpecTaxi extends Taxi{
    private int salary;

    public SpecTaxi() {
    }

    public SpecTaxi(String driver, int age, int salary) {
        super(driver, age);
        this.salary = salary;
    }

    @Override
    public String toString() {
        String str = String.format("%s,%d,%d"
                                , driver, age, salary);
        return str;
    }
    
    public void setData(){
        String ag = String.format("%d", age);
        StringBuilder sb = new StringBuilder(driver);
        sb.replace(1, 2, ag);
        this.driver = sb.toString();
    }
    
    public int getValue(){
        if(age % 2 == 0){
            return salary;
        }else{
            return salary + age;
        }
    }
    
}
