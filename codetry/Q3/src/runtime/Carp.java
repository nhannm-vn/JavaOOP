package runtime;

public class Carp {
    private String pond;
    private int state;

    public Carp(String pond, int state) {
        this.pond = pond;
        this.state = state;
    }

    public Carp() {
    }

    public String getPond() {
        return pond;
    }

    public void setPond(String pond) {
        this.pond = pond;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}
