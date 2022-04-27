package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 시간초과 실패
 */
public class 조합_5607 {

    static int up = 0;      // r+1부터 n까지의 팩토리얼
    static int down = 0;    // 1부터 r까지의 팩토리얼 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int t = Integer.parseInt(br.readLine());
//
//        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            up = 0;
            down = 0;

            upFactorial(n-r+1, n);
            downFactorial(1, r);

            System.out.println(up/down);
//        }


    }

    public static void upFactorial(int start, int end) {
        BigInteger sum = new BigInteger("1");
        for (int i = start; i <= end; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        up = Integer.parseInt(sum.mod(new BigInteger("1000000007")).toString());
    }

    public static void downFactorial(int start, int end) {
        BigInteger sum = new BigInteger("1");
        for (int i = start; i <= end; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        down = Integer.parseInt(sum.mod(new BigInteger("1000000007")).toString());
    }
}
