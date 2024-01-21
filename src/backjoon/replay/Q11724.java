package backjoon.replay;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11724 {
    static int N, M;
    static int[][] map;
    static boolean[] visit;

    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        map = new int[N+1][N+1];
        visit = new boolean[N+1];

        Arrays.fill(visit, false);

        for (int i = 1; i <= M; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            map[u][v] = 1;
            map[v][u] = 1;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(map[i][j] == 1 && !visit[i]) {
                    visit[i] = true;
                    count++;
                    bfs(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(!visit[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int p = q.poll();

            for(int i=1; i<=N; i++) {
                if(map[p][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }

    }
}
