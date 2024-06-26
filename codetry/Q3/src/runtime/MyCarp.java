package runtime;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCarp implements ICarp{

    @Override
    public int f1(List<Carp> t) {
        /*
        int count = 0;
        for (Carp item : t) {
            char tmp = item.getPond().charAt(1);
            if(tmp == '2' || tmp == '0' || tmp == '4' || tmp == '8'){
                count++;
            }
        }
        return count;*/
        int count = 0;
        for (Carp item : t) {
            try {
                int tmp = Integer.parseInt(item.getPond().substring(1, 2));
                if(tmp % 2 == 0){
                    count++;
                }
            } catch (Exception e) {//bo qua cau lenh neu la chu va bi loi
            }
        }
        return count;
        
    }
    private boolean isPalinrom(String str){
        for(int i = 0; i <= (str.length() - 1)/2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    @Override
    public void f2(List<Carp> t) {
        /*
        for (Carp item : t) {
            StringBuilder sb = new StringBuilder(item.getPond());
            String reverse = sb.reverse().toString();
            if(reverse.equals(item.getPond())){
                item.setState(99);
                return;
            }
        }
*/
    }

    @Override
    public void f3(List<Carp> t) {
        Comparator orderByState = new Comparator<Carp>() {
            @Override
            public int compare(Carp t1, Carp t2) {
                if(t1.getState() > t2.getState()){
                    return 1;
                }else{
                    return -1;
                }
            }
        };
        Collections.sort(t, orderByState);
        
    }
    
}
