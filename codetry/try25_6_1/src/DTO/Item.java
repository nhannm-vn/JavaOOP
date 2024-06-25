package DTO;

import java.util.Scanner;

public class Item {
    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        int keyValue = Integer.parseInt(sc.nextLine());
        String keyCreator = sc.nextLine();
        this.setValue(keyValue);
        this.setCreator(keyCreator);
    }
    
    public void output(){
        String str = String.format("%d,%s", value, creator);
        System.out.println(str);
    }
    
}
