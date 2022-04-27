package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 한빈이와SpotMart_9229 {

    public static int arr[];
    public static boolean visit[];
    public static int N, M;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            max = -1;

            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];
            visit = new boolean[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

//            dfs(0, 0);

            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    int sum = arr[i] + arr[j];
                    if (sum <= M && max < sum) {
                        max = sum;
                    }
                }
            }
            System.out.println("#" + testCase + " " + max);
        }
    }

//    public static void dfs(int count, int sum) {
//        if (count == 2 && M >= sum) {
//            // 최대 값을 초과하면 안됨
//            if (max < sum) {
//                max = sum;
//            }
//            return;
//        }
//
//        for (int i = N-1; i >= 0; i--) {
////            System.out.println(i);
//            if (!visit[i]) {
//                visit[i] = true;
//                dfs(count + 1, sum + arr[i]);
//                visit[i] = false;
//            }
//
//            if (max != -1) {
//                return;
//            }
//        }
//    }
}
