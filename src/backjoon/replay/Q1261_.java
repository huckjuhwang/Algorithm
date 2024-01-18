package backjoon.replay;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1261_ {

    static int N, M, start;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        start = scan.nextInt();

        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        Arrays.fill(visit, false);

        for(int i=1; i<=M; i++) {

            int x = scan.nextInt();
            int y = scan.nextInt();

            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(start);

        Arrays.fill(visit, false);
        System.out.println();

        bfs(start);
    }

    public static void bfs(int now) {
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        visit[now] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for(int i=1; i<=N; i++) {
                if(!visit[i] & map[i][x] == 1) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }


    public static void dfs(int now) {
        System.out.print(now + " ");
        visit[now] = true;

        for(int i=1; i<=N; i++) {
            if(!visit[i] && map[i][now] == 1) {
                dfs(i);
            }
        }
    }
}
