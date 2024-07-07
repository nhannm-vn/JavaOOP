package runtime;

import java.util.StringTokenizer;

public class MyString implements IString{

    @Override
    public int f1(String str) {
        int count = 0;
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            if(tmp.substring(0, 1).matches("\\d")
             && tmp.substring(tmp.length() - 1, tmp.length()).matches("\\d")){
                count++;
            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        String result = "";
        int count = 0;
        String tmp = "";
        for(int i = 0; i <= str.length() - 1; i++){
            if(str.substring(i, i+1).matches("\\D")){
                tmp = str.substring(i,i+1);
                break;
            }
        }
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i <= str.length() - 1; i++){
            if(str.substring(i, i+1).matches("(0|2|4|6|8)")){
                count++;
            }
            
            if(count == 2){
                sb.replace(i, i+1, tmp);
                break;
            }
        }
        return sb.toString();
    }
    
}
