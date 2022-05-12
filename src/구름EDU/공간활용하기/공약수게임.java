package 구름EDU.공간활용하기;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 공약수게임 {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_VALUE = 1000000;

    /**
     * 게임의 규칙을 만족하면서 만들 수 있는 가장 큰 최대공약수를 반환하는 함수
     */
    public static int getMaximumGCD(int n, int[] cards)
    {
        int result = 1;
        // 빈도 수를 저장하기 위한 테이블
        int frequency[] = new int[MAX_VALUE + 1];

        for (int c : cards) {
            // 1. 각 카드에 대한 소인수 계산
            ArrayList<Long> factorize = MathUtil.factorize(c);
            // 2. 모든 소인수의 빈도수 저장
            for (long prime : factorize)
                frequency[(int)prime]++;
        }


        for (int i = 2; i <= MAX_VALUE ; i++) {
            // 소인수가 등장하지 않았다면,
            if (frequency[i] == 0) {
                continue;
            }

            // 3.각 소인수를 N개로 분활 했을때, 최소값을 계산(특정 소인수에 대한 전체개수/카드개수)
            int count = frequency[i] / n;
            // 4. 분활한, 소인수의 최소개수로 GCD계산
            result *= Math.pow(i, count);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] cards = new int[n];
        for(int i = 0 ; i < n ; i++) {
            cards[i] = scanner.nextInt();
        }

        int answer = getMaximumGCD(n, cards);
        System.out.println(answer);
    }

}

class MathUtil{
    /**
     * N에 대한 소인수를 구하는 메서드
     */
    public static ArrayList<Long> factorize(long N) {
        ArrayList<Long> result = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                result.add((long)i);
                N /= i;
            }
        }
        // 합성수 일 경우
        if (N > 1)  result.add(N);

        return result;
    }
}


