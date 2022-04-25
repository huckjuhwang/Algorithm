package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_2817 {

    public static int K;
    public static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            count = 0;
            boolean visit[] = new boolean[N];

            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(arr, 0, 0);

            System.out.println("#" + testCase + " " + count);
        }
    }

    public static void dfs(int arr[],int sum, int start){
        if(sum==K) {
            count++;
            return;
        } else if (sum > K || start == arr.length) {
            return;
        }


        dfs(arr, sum + arr[start], start + 1);
        // 선택 하지 않았을 경우
        dfs(arr, sum, start+1);
    }
}
