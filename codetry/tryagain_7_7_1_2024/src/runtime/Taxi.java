package runtime;

public class Taxi {
    private String driver;
    private int age;

    public Taxi() {
    }

    public Taxi(String driver, int age) {
        this.driver = driver;
        this.age = age;
    }

    public String getDriver() {
        return driver;
    }

    public int getAge() {
        return age;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        String str = String.format("%s,%d", driver, age);
        return str;
    }
    
    
}
