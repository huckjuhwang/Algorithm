package backjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q9020 {

    static boolean isPrime[];
    static int MAX_VAL = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrime = new boolean[MAX_VAL + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;

        // 에라토스테네스의 체 알고리즘 구현
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= MAX_VAL; i++) {
            // 소수라면,
            if (isPrime[i]) {
                prime.add(i);
                for (long j = (long)i*i; j <= MAX_VAL; j += i) {
                    isPrime[(int)j] = false;
                }
            }
        }


        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int k = Integer.parseInt(br.readLine());
            StringBuilder sb= new StringBuilder();

            int min = Integer.MAX_VALUE;
            int val_x = 0;
            int val_y = 0;

            for (int x : prime) {
                // target값 보다 X의 값이 커질 경우 이후 값은 순회할 필요가 없음.
                if (k < x)  break;
                int y = k-x;

                // y가 존재한다면.
                if( isPrime[y] ){
                    if (Math.abs(x - y) < min) {
                        val_x = x;
                        val_y = y;
                        min = Math.abs(x - y);
                    }
                }
            }



            System.out.println(val_x + " " + val_y);

        }
    }
}
