package data;

public abstract class  Student {
    //props
    protected String rollNumber;
    protected String name;
    protected String phone;
    
    //constructor

    public Student(String rollNumber, String name, String phone) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.phone = phone;
    }

    public Student() {
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    //toString

    @Override
    public String toString() {
        String str = String.format("%s,%s,%s", rollNumber, name, phone);
        return str;
    }
    
    public abstract double mediumScore();
    
    public abstract String classification();
    
}
