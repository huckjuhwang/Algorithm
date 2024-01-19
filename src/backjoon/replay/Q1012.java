package backjoon.replay;

import java.util.Scanner;

public class Q1012 {

    static int map[][];
    static int visit[][];

    static int x[] = {1, -1, 0, 0};
    static int y[] = {0, 0, 1, -1};

    // 가로/세로
    static int N, M;
    // 배추 갯수
    static int K;
    // 지렁이 필요 갯수
    static int count;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for (int q = 0; q < t; q++) {
            count = 0;

            N = scan.nextInt();
            M = scan.nextInt();
            K = scan.nextInt();

            map = new int[N][M];
            visit = new int[N][M];

            for(int i=0; i<K; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();

                map[a][b] = 1;
            }


            for (int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(visit[i][j] == 0 && map[i][j] == 1) {
                        visit[i][j] = 1;
                        count++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }


    public static void dfs(int nowX, int nowY) {
        for(int i=0; i<4; i++) {
            int nextX = nowX + x[i];
            int nextY = nowY + y[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }


            if(map[nextX][nextY] == 1 && visit[nextX][nextY] == 0) {
                visit[nextX][nextY] = 1;
                dfs(nextX, nextY);
            }

        }

    }
}
