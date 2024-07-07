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
        String str = String.format("%s,%d,%d", getDriver(), getAge(), salary);
        return str;
    }
    
    public void setData(){
        String str = String.format("%d", getAge());
        StringBuilder sb = new StringBuilder(getDriver());
        sb.replace(1, 2, str);
        setDriver(sb.toString());
    }
    
    public int getValue(){
        if(getAge() % 2 == 0){
            return salary;
        }else{
            return salary + getAge();
        }
    }
    
    
}
