package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두전구_12741 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int arr[] = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] =  Integer.parseInt(st.nextToken());
            }
            int A = arr[0];
            int B = arr[1];
            int C = arr[2];
            int D = arr[3];
            Arrays.sort(arr);

            if ((B < C && B < D) || (D < A && D < B)) {
                System.out.println("#" + testCase + " " + 0);
            }else{
                System.out.println("#" + testCase + " " + (arr[2]-arr[1]));
            }
        }
    }
}
