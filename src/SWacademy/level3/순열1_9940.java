package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순열1_9940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            boolean check = true;
            for (int i = 0; i < N; i++) {
                if (arr[i] != i + 1) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println("#" + testCase + " " + "Yes");
            }else{
                System.out.println("#" + testCase + " " + "No");
            }
        }
    }
}
