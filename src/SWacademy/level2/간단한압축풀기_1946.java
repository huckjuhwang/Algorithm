package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 간단한압축풀기_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String arr[][] = new String[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = st.nextToken();
                arr[i][1] = st.nextToken();
            }

            int count = 0;
            System.out.println("#" + testCase);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < Integer.parseInt(arr[i][1]); j++) {
                    System.out.print(arr[i][0]);
                    count++;
                    if (count == 10) {
                        count=0;
                        System.out.println();
                    }
                }

            }
        }

    }
}
