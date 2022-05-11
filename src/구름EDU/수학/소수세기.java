package 구름EDU.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수세기 {

    static boolean isPrime[];
    static int MAX_SIZE = 1000000;

    public static void main(String[] args) throws IOException {

        isPrime = new boolean[MAX_SIZE + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[2] = true;

        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= MAX_SIZE; i++) {
            // 소수라면
            if (isPrime[i]) {
                prime.add(i);
                for (long j = i+i; j <= MAX_SIZE; j += i) {
                    isPrime[(int)j] = false;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int testCase = 1; testCase <= t ; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int num : prime) {
                if (num >= L && num <= R)
                    count++;
                if(num > R) break;
            }

            System.out.println("Case #" + testCase + ": \n" + count);
        }


    }
}
