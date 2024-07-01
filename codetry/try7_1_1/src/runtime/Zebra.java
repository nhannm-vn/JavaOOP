package runtime;

public class Zebra {
    private String owner;
    private int weight;

    public Zebra(String owner, int weight) {
        this.owner = owner;
        this.weight = weight;
    }

    public Zebra() {
    }

    public String getOwner() {
        String tmp = this.owner;
        StringBuilder sb = new StringBuilder(tmp);
        for(int i = 0; i <= sb.length() - 1; i++){
            if(sb.substring(i, i + 1).toString().matches("^(0|2|4|6|8)$")){
                sb.deleteCharAt(i);
                i--;
            }
        }
        String result = sb.toString();
        return result;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight - owner.length();
    }
    
    
}
