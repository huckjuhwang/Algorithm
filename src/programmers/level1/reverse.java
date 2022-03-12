package programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class reverse {

    public static void main(String[] args) {
        long solution = solution(118372);
        System.out.println("solution = " + solution);
    }

    public static long solution(long n) {
        String num = n + "";
        int nums[] = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
        }

        Arrays.sort(nums);

        String answer = "";
        for (int i = nums.length-1; i >= 0; i--) {
            answer += nums[i];
        }
        return Long.parseLong(answer);
    }
}
