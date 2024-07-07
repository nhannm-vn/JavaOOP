package runtime;

import java.util.StringTokenizer;

public class MyString implements IString{

    @Override
    public int f1(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        int count = 0;
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            if(tmp.matches("^\\D{1}(1|3|5|7|9)\\d*$") 
                    || tmp.matches("\\D{1}\\d*(1|3|5|7|9)$")){
                count++;
            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String result = "";
        int count = 0;
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            StringBuilder sb = new StringBuilder(tmp);
            if(sb.reverse().toString().equals(tmp)){
                count++;
            }
            if(count == 1){
                result += "XX" + " ";
                count++;
            }else if(count != 1){
                result += tmp + " ";
            }
            
        }
        return result;
    }
    /*
    public int checkPrime(int n){
        if(n >= 2){
            for(int i = 2; i <= n - 1; i++){
                if(n % i == 0){
                    return 0;
                }
            }
            return 1;
        }else{
            return 0;
        }
    } 
            
    @Override
    public int f1(String str) {
        int sum = 0;
        for(int i = 0; i <= str.length() - 1; i++){
            String tmp = str.substring(i, i+1);
            if(tmp.matches("\\d")){
                if(checkPrime(Integer.parseInt(tmp)) == 1){
                    sum += Integer.parseInt(tmp);
                }
            }
        }
        return sum;
    }

    @Override
    public String f2(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String tmp = "";
        String result = "";
        while(st.hasMoreTokens()){
            tmp = st.nextToken();
            if(tmp.matches("^[a][b]$")){
                result += "T" + " ";
            }else{
                result += tmp + " ";
            }
            
        }
        return result;
        
    }
    */
}
