package runtime;

import java.util.StringTokenizer;

public class MyUtilities implements IUtilities{

    @Override
    public int sumNumber(int number) {
        int sum = 0;
        for(int i = 1; i <= number / 2; i++){
            if(number % i == 0){
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public String replaceString(String sentence, String s1, String s2) {
        String result = "";
        StringTokenizer st = new StringTokenizer(sentence, " ");
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            if(tmp.length() == s1.length()){
                result += s2 + " ";
            }else{
                result += tmp + " ";
            }
        }
        return result;
    }
    
}
