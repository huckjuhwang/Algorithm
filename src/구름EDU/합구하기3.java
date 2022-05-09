package 구름EDU;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 *   평소 머리가 나쁘다고 놀림을 자주 듣는 예인이는 몰래 수학 공부를 하고 있다.
 *   수학 공부를 하던 예인이는 자연수에 대한 깊은 고찰을 하게 되었다.
 *   어떤 자연수 N이 있다고 했을 때 1이상 N 이하의 모든 자연수의 합은 손 쉽게 계산할 수 있다. 어떤 자연수 N이 있다고 했을 때,
 *   아래와 같은 식의 값은 어떻게 계산할 수 있을까?
 *
 *
 *  (1이상 1이하의 모든 자연수의 합) + (1이상 2이하의 모든 자연수의 합) + ... +(1이상 N이하의 모든 자연수의 합)
 *
 *
 *   어릴적부터 주술같은 주산을 배운 예인이는 위의 식을 계산하며 자신의 암산 능력을 다지기로 결정했다.
 *   하지만 자신이 계산한 값이 정답이 맞는지 검증 할 수 없었던 예인이는 당신에게 자연수 N을 입력하면 위의 식으로 계산한 결과를 알려주는 프로그램을 요구했다.
 *   컴퓨터를 잘 다룬다고 주변에 소문난 당신은 귀여운 예인이를 위하여 프로그램을 작성해주기로 결정하였다.
 *
 *
 *   첫 해결법은 DP를 사용하여 해결,
 *
 *   이후는 등차 수열의 합을 사용하여 해결,
 */

public class 합구하기3 {
    public static final Scanner scanner = new Scanner(System.in);
    static int dp[];

    /**
     * 1부터 M까지의 자연수의 합을 계산하는 함수
     * @param M
     * @return
     */
    public static int getRangeSumFromOne(int M) {
//        return dp[M - 1] + M;
        return (M * (M + 1)) / 2;
    }

    /**
     * N에 대한 정답을 계산하는 함수
     * @param N
     * @return
     */
    public static long getAnswer(int N)
    {
        dp = new int[N+1];
        long answer = 0;

        for (int i = 1; i <= N; i++)
            answer += getRangeSumFromOne(i);

//        for (int i = 1; i <= N; i++)
//            answer += dp[i];

        return answer;
    }


    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        long answer = getAnswer(n);
        System.out.println(answer);
    }

}


