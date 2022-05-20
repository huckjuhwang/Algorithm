package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최고의쌍_9839 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;

            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    int mul = arr[i] * arr[j];
                    if (mul < 10 || isIncrement(mul)) {
                        max = Math.max(max, mul);
                    }
                }
            }
            System.out.println("#" + testCase + " " + max);
        }
    }

    public static boolean isIncrement(int mul) {
        String num = Integer.toString(mul);
        int start = num.charAt(0) - '0';
        int idx = 0;
        for (int i = start; i < start + num.length(); i++) {
            int ch = num.charAt(idx) - '0';
            if (ch != i) {
                return false;
            }
            idx++;
        }

        return true;
    }
}
