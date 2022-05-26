package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소득불균형_10505 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];

            int sum = 0;
            double avg = 0.0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            avg = (double) sum / n;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] <= avg) {
                    count++;
                }
            }

            System.out.println("#" + testCase + " " + count);
        }


    }
}
