package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퍼펙드셔플_3499 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String arr[] = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }

            int oddIDX = 0;
            int evenIDX = n % 2 == 0 ? n / 2 : n / 2 + 1;
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    sb.append(arr[oddIDX++]).append(" ");
                }else{
                    sb.append(arr[evenIDX++]).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
