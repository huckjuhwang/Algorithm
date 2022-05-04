package backjoon;

import java.io.IOException;
import java.util.Scanner;

public class Q14888 {

    // 덧셈, 뺄센, 곱셈, 나눗셈
    static int pmmd[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int arr[];
    static int n;
    static boolean visit[];

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        arr = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        pmmd = new int[4];
        for (int i = 0; i < 4; i++) {
            pmmd[i] = scan.nextInt();
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int total){
        // 종료조건
        if (depth == n) {
            min = Math.min(min, total);
            max = Math.max(max, total);
            return;
        }


        for (int j = 0; j < 4; j++) {
            if (pmmd[j] != 0) {
                pmmd[j]--;
                switch (j) {
                    case 0: dfs(depth+1, total + arr[depth]);  break;
                    case 1: dfs(depth+1, total - arr[depth]);  break;
                    case 2: dfs(depth+1, total * arr[depth]);  break;
                    case 3: dfs(depth+1, total / arr[depth]);  break;
                }
                pmmd[j]++;
            }
        }
    }
}
