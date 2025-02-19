package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q1260 {

    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};

    static int N, M, V;

    static int[][] map;
    static boolean[] visit;

    // 정점의 갯
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        Arrays.fill(visit, false);

        for(int i =1; i<=M; i++) {
            String[] s = scan.nextLine().split(" ");

            int inputX = Integer.parseInt(s[0]);
            int inputY = Integer.parseInt(s[1]);

            map[inputX][inputY] = 1;
            map[inputY][inputX] = 1;
        }
    }


    public void dfs(int start) {
        visit[start] = true;
        System.out.println(start);


        for(int i=1; i<=N; i++) {
            if(!visit[i] && map[start][i] == 1) {
                dfs(i);
            }
        }
    }

}
