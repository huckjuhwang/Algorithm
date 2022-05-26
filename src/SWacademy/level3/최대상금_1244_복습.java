package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대상금_1244_복습 {
    static int n, size;
    static boolean visit[];
    static char number[];
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            number = st.nextToken().toCharArray();
            n = Integer.parseInt(st.nextToken());
            visit = new boolean[size];
            size = number.length;
            max = 0;

            // 완전탐색 start
            dfs(0, 0);
            System.out.println("#" + testCase + " " + max);
        }

    }

    public static void dfs(int start, int depth) {
        // 종료조건 ( change가 n번만큼 되었을 경우 )
        if (depth == n) {
            int now = Integer.parseInt(new String(number));
            max = Math.max(max, now);   // 현재 값이 더 클경우 변경
            return;
        }


        for (int i = start; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                swap(i, j);
                dfs(i, depth + 1);
                swap(i, j);
            }
        }
    }

    public static void swap(int x, int y) {
        char temp = number[x];
        number[x] = number[y];
        number[y] = temp;
    }
}
