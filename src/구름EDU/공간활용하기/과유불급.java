package 구름EDU.공간활용하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 과유불급 {
    // 10시14분 시작
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        long max = 0;
        int maxIDX = 0;
        long rangeSum[] = new long[n+1];


        rangeSum[0] = 0;

        for (int i = 1; i <= n; i++) {
            rangeSum[i] = rangeSum[i - 1] + arr[i];
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken());

            long sum = rangeSum[r] - rangeSum[l];
            if( max < sum ){
                max = sum;
                maxIDX = i+1;
            }
        }

        System.out.print(maxIDX+ " " + max + " ");
    }
}
