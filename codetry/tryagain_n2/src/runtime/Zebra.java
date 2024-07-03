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
        String result = "";
        StringBuilder sb = new StringBuilder(owner);
        
        for(int i = 0; i <= sb.length() - 1; i++){
            if(sb.subSequence(i, i + 1).toString().matches("\\d")){
                if(sb.subSequence(i, i + 1).toString().matches("^(0|2|4|6|8)$")){
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }
        return sb.toString();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight - owner.length();
    }
    
    
    
}
