package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        long max = 0;
        long min = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        while (min < max) {
            long mid = (max + min) / 2;
            long sum = 0;

            // mid로 짤랐을때, 남는 나무의 길이 출력
            for (int i = 0; i < N; i++) {
                sum += (arr[i] - mid) < 0 ? 0 : (arr[i] - mid) ;
            }


            if (sum < target) {
                max = mid;
            }else{
                min = mid+1;
            }
        }

        System.out.println(max-1);
    }
}
