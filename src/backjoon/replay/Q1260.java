package backjoon.replay;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1260 {

    static int N, M, V;

    // 동, 서, 남, 북
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};

    static int[][] map;
    static boolean[] visit;

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

        // 첫째줄 dfs
        dfs(start);

        visit = new boolean[N+1];
        Arrays.fill(visit, false);
        System.out.println();

        // 둘째줄 bfs
        bfs(start);

    }

    public static void dfs(int start) {
        visit[start]= true;
        System.out.print(start + " ");

        for(int i=1; i<=N; i++) {
            if(!visit[i] && map[start][i] == 1){
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i=1; i<=N; i++) {
                if(map[temp][i] == 1 && !visit[i]) {
                    q.offer(i);
                    System.out.print(i + " ");
                    visit[i] = true;
                }
            }
        }
    }

    public static boolean isAllVisit() {
        // 다 True인지 체크
        for (int i =1; i<=N; i++) {
            if(!visit[i]) {
                return false;
            }
        }
        return true;
    }
}
