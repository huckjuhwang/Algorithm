package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주스나누기_5601 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < n; i++) {
                sb.append(1).append("/").append(n).append(" ");
            }
            System.out.println(sb);
        }
    }
}
