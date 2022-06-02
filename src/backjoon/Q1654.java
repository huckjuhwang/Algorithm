package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[K];

        long max = 0, min= 0, mid = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int count = 0;
        max++;

        while (min < max) {
            mid = (max + min) / 2;
            count = 0;

            for (int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }

            if (count < N) {
                max = mid;
            }else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}
