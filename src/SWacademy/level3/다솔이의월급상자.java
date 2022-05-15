package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다솔이의월급상자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            double avg = 0.0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                double p = Double.parseDouble(st.nextToken());
                double money = Double.parseDouble(st.nextToken());

                avg += p * money;
            }

            System.out.println("#" + testCase + " " + avg);
        }
    }
}
