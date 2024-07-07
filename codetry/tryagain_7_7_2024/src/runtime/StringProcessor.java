package runtime;

import java.util.StringTokenizer;

public class StringProcessor {
    public static boolean match_student_id(String s){
        if(s.matches("^(se|SE|sE|Se|he|HE|hE|He|qe|QE|qE|Qe)\\d{4,6}$")){
            return true;
        }else{
            return false;
        }
    }
    
    public static String format_camel(String s){
        /*
        String tmp = s.toLowerCase();
        String result = "";
        String rye = "";
        int count = 0;
        StringTokenizer st = new StringTokenizer(tmp, "_");
        while(st.hasMoreTokens()){
            rye = st.nextToken();
            if(count >= 1){
                rye = rye.substring(0, 1).toUpperCase() + rye.substring(1, rye.length());
            }
            result += rye;
            count++;
        }
        return result;*/
        String tmp = s.toLowerCase();
        StringBuilder rye = new StringBuilder(tmp);
        for(int i = 0; i <= rye.length() - 1; i++){
            if(rye.substring(i, i+1).toString().matches("^[_]$")){
                
                rye.replace(i+1, i+2, rye.substring(i+1, i+2).toUpperCase());
                rye.deleteCharAt(i);
                i--;
            }
        }
        return rye.toString();
    }
    
}
