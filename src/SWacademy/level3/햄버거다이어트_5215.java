package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거다이어트_5215 {

    static int L;   // 제한 칼로리
    static int N;   // 재료 개수 ( 중복X )
    static int max; // 최대 맛의 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            max = 0;
            int arr[][] = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(arr, 0, 0,  0);
            System.out.println("#" + testCase + " " + max);
        }
    }

    static void dfs(int arr[][], int nowK, int deli,  int count) {

        /** 기저 사례 **/
        // 칼로리 초과
        if (nowK > L)  return;
        // 모든재료를 사용했을 경우
        if (count == N) {
            if( max < deli ) max = deli;
            return;
        }

        // 현재 값이 MAX
        if ( max < deli)   max = deli;

        /** 재료를 선택하였을 경우 **/
        dfs(arr, nowK + arr[count][1], deli+arr[count][0],  count+1);
        /** 현재 재료를 선택하지 않았을 경우 **/
        dfs(arr, nowK, deli, count + 1);

    }
}
