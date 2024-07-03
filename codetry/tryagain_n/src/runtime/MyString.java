package runtime;

import java.util.StringTokenizer;

public class MyString implements IString{

    public static int checkPrime(int n){
        if(n >= 2){
            for(int i = 2; i <= n - 1; i++){
                if(n % i == 0){
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }
    
    @Override
    public int f1(String str) {
        int sum = 0;
        for(int i = 0; i <= str.length() - 1; i++){
            if(str.substring(i, i+1).matches("\\d")){
                String tmp = str.substring(i, i+1);
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
        int count = 0;
        String result = "";
        while(st.hasMoreElements()){
            String tmp = st.nextToken();
            if(tmp.equals("ab")){
                result += "T" + " ";
            }else{
                result += tmp + " ";
            }
        }
        return result;
    }
    
}
