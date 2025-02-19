package wented.to;

import java.util.Arrays;

class Solution {
    public int solution(int[] levels) {
        int answer = 0;

        Arrays.sort(levels);

        double count = levels.length - Math.floor(Double.parseDouble(levels.length + "") * 0.25);
        try {
           return  levels[(int) count];
        } catch (Exception e) {
            return -1;
        }

    }
}