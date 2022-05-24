package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q1990 {
    static int maxSize = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> isPrime = new ArrayList<>();
        boolean check[] = new boolean[maxSize+1];

        check[0] = true;
        check[1] = true;


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        
        for (int i = 2; i <= to; i++) {
            if (!check[i]) {
                isPrime.add(i);
                for (long j = (long)i * i; j <= to; j+=i) {
                    check[(int)j] = true;
                }
            }
        }

        for (int num : isPrime) {
            if (num > to)   break;
            if (num < from) continue;

            if (isPalindrom(num))  System.out.println(num);
        }
        System.out.println(-1);
    }

    private static boolean isPalindrom(int num) {
        return Integer.toString(num).equals(new StringBuilder(Integer.toString(num)).reverse().toString());
    }
}
