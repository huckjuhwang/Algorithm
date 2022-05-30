package wented.ka;

import java.util.Arrays;

public class Main3 {


    public static void main(String[] args) {
        solution(new int[]{3,-1,0,4});
//        solution(new int[]{1,2,3});
//        solution(new int[]{15,11,4,8,5,2,4});
    }
    // idx 기준으로 짝수보단 홀수가 값이 무조건 커야함
    // 현재 S를 순차탐색을 진행하며, 현재 탐색하는값을 IDX라고 했을때,
    // IDX 와 IDX+1을 비교해가며, 각 조건에 불일치 할 경우 count++;
    // s의 사이즈를 N이라고 했을때, 시간복잡도는 O(N)을 가지게 된다.
    public static int solution(int[] s) {

        int n = s.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 짝수일때
                if ((i % 2 == 1) && (s[i] > s[j]) ) {
                    dp[i] = Math.max(dp[i] + 1, dp[j]);
                } else if ((i % 2 == 0) && (s[i] < s[j])) {
                    dp[i] = Math.max(dp[i] + 1, dp[j]);
                }
            }
        }

        return 1;
    }
}
