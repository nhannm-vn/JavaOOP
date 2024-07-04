package runtime;
public class StringProcessor {
    public static boolean match_student_id(String s){
        if(s.matches("^(se|Se|sE|SE|he|HE|He|hE|qe|Qe|QE|qE)\\d{4,6}$")){
            return true;
        }else{
            return false;
        }
    }
    
    public static String format_camel(String s){
        String tmp = s.toLowerCase();
        StringBuilder sb = new StringBuilder(tmp);
        for(int i = 0; i <= sb.length() - 1; i++){
            if(sb.substring(i, i+1).toString().matches("^[_]$")){
                String sub = sb.substring(i+1, i+2).toString().toUpperCase();
                sb.replace(i+1, i+2, sub);
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
    
}
