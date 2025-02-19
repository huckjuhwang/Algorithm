package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class book5_5_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] solution(int[] answers) {

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if(one[i%one.length] == answers[i]) {
                score[0]++;
            }

            if(two[i%two.length] == answers[i]) {
                score[1]++;
            }

            if(three[i%three.length] == answers[i]) {
                score[2]++;
            }
        }

        int max = Arrays.stream(score).max().getAsInt();

        for (int i = 0; i < score.length; i++) {
            if(score[i] == max) {
                result.add(i+1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
