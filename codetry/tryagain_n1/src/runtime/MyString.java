package runtime;

import java.util.StringTokenizer;

public class MyString implements IString{

    @Override
    public int f1(String str) {
        int count = 0;
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreElements()){
            String tmp = st.nextToken();
            if(tmp.substring(0, 1).matches("\\d") && 
                    tmp.substring(tmp.length() - 1, tmp.length()).matches("\\d")){
                count++;
            }
        }
        return count;
    }

    /*
    đề nhập vào 1 chuỗi lấy ra 3 kí tự cuối cùng , cái chuỗi lấy ra được lowercase thằng thứ 2 
    */
    @Override
    public String f2(String str) {
        String sub = str.substring(str.length() - 3, str.length());
        String result = sub.substring(0, 1) + sub.substring(1, 2).toLowerCase() 
                + "" + sub.substring(2, sub.length());
        return result;
    }
    
    public String f3(String str){
        char keyChar = 0;
        for(int i = 0; i <= str.length() - 1; i++){
            if(str.substring(i, i+1).matches("\\D")){
                keyChar = str.charAt(i);
                break;
            }
        }
        int count = 0;
        int pos = 0;
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i <= str.length() - 1; i++){
            if(str.substring(i, i + 1).matches("^(0|2|4|6|8)$")){
                count++;
                pos = i;
            }
            if(count == 2){
                sb.setCharAt(pos, keyChar);
                break;
            }
        }
        return sb.toString();
    }
    
}
