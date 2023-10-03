package programmers.level1;

import java.util.Arrays;

class EqualsText {
    public static void main(String[] args) {
        System.out.println(solution("aaabbbccc"));
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        int[] position = new int[26];
        Arrays.fill(position, -1);

        for(int i =0; i<s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if(position[index] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i-position[index];
            }

            position[index] = i;
        }

        return answer;
    }
}