package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부먹왕국의차원관문_7964 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int dp[] = new int[N];

            int result = 0;

            if (arr[0] == 0) {
                result++;
                arr[0] = 1;
            }

            if (arr[N - 1] == 0) {
                result++;
                arr[N-1] = 1;
            }


            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == 1)   {
                    cnt = 0;
                }else{
                    cnt++;
                    if (D == cnt) {
                        cnt = 0;
                        result++;
                    }
                }
            }
            System.out.println("#" + testCase + " " + result);
        }
    }
}
