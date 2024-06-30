package runtime;

import java.util.StringTokenizer;

public class MyString implements IString{
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
    public int f1(String str) {//tinh tong cac so nguyen to trong chuoi
        int sum = 0;
        String tmp = null;
        for(int i = 0; i <= str.length() - 1; i++){
            if(str.substring(i, i+1).matches("\\d")){
                tmp = str.substring(i, i+1);
                int number = Integer.parseInt(tmp);
                if(checkPrime(number) == 1){
                    sum += number;
                }
            }
        }
        return sum;
    }

    @Override
    public String f2(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String tmp = null;
        String result = "";
        while(st.hasMoreElements()){
            tmp = st.nextToken();
            if(tmp.equals("ab")){
                result += "T" + " ";
            }else{
                result += tmp + " ";
            }  
        }
        return result;
    }
    
}
