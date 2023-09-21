package programmers.level1;

import java.util.*;

class Passwords {

    public String solution(String s, String skip, int index) {
        String answer = "";

        // skip set 셋팅
        Set<Integer> skipSet = new HashSet();
        for(int i=0; i<skip.length(); i++) {
            skipSet.add((int)skip.charAt(i) - 97);
        }


        for (char letter : s.toCharArray()) {
            int nowLetter = (int)letter - 97;

            for(int i = 0; i<index; i++) {
                do {
                    nowLetter = (nowLetter + 1) % 26;
                } while(skipSet.contains(nowLetter));
            }

            answer += (char)(nowLetter + 97);
        }

        return answer;
    }
}