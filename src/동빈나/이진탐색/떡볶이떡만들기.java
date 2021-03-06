package 동빈나.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = arr[0];
        int end = arr[N-1];

        int result = 0;


        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                sum += (arr[i]-mid) < 0 ? 0 : arr[i]-mid;
            }
            if (sum < M) {
                end = mid-1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }


}
