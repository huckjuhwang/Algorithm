package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 몬스터사냥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int i = 0; i < N; i++) {
                double val = D * (1 + (i * ((double)L * 0.01)));
                sum += val;
            }
            System.out.println("#" + testCase + " " + sum);
        }
    }
}
