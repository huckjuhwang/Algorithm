package programmers.level1;

import java.util.*;

class paintOver {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int temp = m;
        int count = 1;

        if(m == 1) {
            return section.length;
        }

        for(int i =0; i<section.length-1; i++) {
            int now = section[i];
            int next = section[i+1];

            temp = temp - (next-now);
            if(temp <= 0) {
                count++;
                temp = m;
            }

        }
        return count;
    }
}