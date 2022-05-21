package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 테네스의특별한소수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean isPrime[] = new boolean[1000001];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        int size = isPrime.length-1;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= size; i++) {
            // 소수이면
            if (isPrime[i]) {
                list.add(i);
                for (long j = (long)i * i; j <= size; j += i) {
                    isPrime[(int)j] = false;
                }
            }
        }

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int num : list) {
                if (num >= A && num <= B) {
                    if (Integer.toString(num).contains(Integer.toString(D))) {
                        count++;
                    }
                }

                else if (B < num) break;

            }

            System.out.println("#" + testCase + " " + count);

        }
    }
}
