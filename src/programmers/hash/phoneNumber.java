package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class phoneNumber {

    public static void main(String[] args) {
        phoneNumber pn = new phoneNumber();
        int solution = pn.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println("solution = " + solution);
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> hm = getHashMap(clothes);
        return getResult(hm);
    }

    private int getResult(Map<String, Integer> hm) {
        Set<String> keySet = hm.keySet();
        int result = 1;
        for( String key : keySet ) {
            result *= hm.get(key)+1;
        }
        return result-1;
    }

    private Map<String, Integer> getHashMap(String[][] clothes) {
        Map<String, Integer> hm = new HashMap<>();
        for (String clo[] : clothes){
            String key = clo[1];
            if( hm.get(key) == null ){
                hm.put(key, 1);
            }else {
                hm.put(clo[1], hm.get(key)+1);
            }
        }
        return hm;
    }

}
