package runtime;

import java.util.StringTokenizer;

public class MyString implements IString{

    @Override
    public int f1(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String tmp = null;
        int count = 0;
        while(st.hasMoreElements()){
            tmp = st.nextToken();
            if(tmp.substring(0, 1).matches("\\d") && 
             tmp.substring(tmp.length() - 1, tmp.length()).matches("\\d")){
                count++;
            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        char key = 0;
        int count = 0;
        int pos = 0;

        for(int i = 0; i <= str.length() - 1; i++){
            if(str.substring(i, i+1).matches("[a-z]")){
                key = str.charAt(i);
                break;
                
            }
        }
        for(int i = 0; i <= str.length() - 1; i++){
            if(str.substring(i, i + 1).matches("^(0|2|4|6|8)$")){
                count++;
            }
            if(count == 2){
                pos = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(pos, key);
        String result = sb.toString();
        return result;
        
    }
    
}
