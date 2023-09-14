package programmers.level1;

import java.util.*;

class roughlyMadeJapang {


    public static void main(String[] args) {
        solution(new String[]{"AA"}, new String[]{"B"});
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<String, Integer> map = new HashMap<>();

        for(String key : keymap) {
            for(int i=0; i<key.length(); i++){
                String ch = key.charAt(i) + "";
                int value = i+1;

                if(map.get(ch) == null){
                    map.put(ch, value);
                } else {
                    if(map.get(ch) > value) {
                        map.put(ch, value);
                    }

                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;

            for (int j = 0; j < target.length(); j++) {
                Integer value = map.get(target.charAt(j) + "");

                if (value == null) {
                    sum = -1;
                    break;
                } else {
                    sum += value;
                }
            }
            answer[i] = sum;
            System.out.println(sum);
        }
        return answer;
    }
}