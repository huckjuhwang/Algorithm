package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거듭제곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;

        for (int testCase = 1; testCase <= t; testCase++) {
            br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println("#" + testCase + " " + sqrt(n, m));
        }
    }

    public static int sqrt(int n, int m) {
        if (m == 0) {
            return 1;
        }
        return n * sqrt(n, m-1);
    }
}
