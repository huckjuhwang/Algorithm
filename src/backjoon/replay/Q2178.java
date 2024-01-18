package backjoon.replay;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {


    static int N, M;
    static int[][] map;


    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String line = scan.nextLine();

            for(int j=0; j<M; j++) {
                int ch = line.charAt(j) - '0';
                map[i][j] = ch;
            }
        }

        // bfs
        bfs(0, 0);

        System.out.println(map[N-1][M-1]);
    }


    public static void bfs(int a, int b) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(a, b));
//        map[a][b]--;

        while (!q.isEmpty()) {
            Point point = q.poll();
            int nowX = point.x;
            int nowY = point.y;


            for(int i =0; i<4; i++) {
                int nextX = nowX + x[i];
                int nextY = nowY + y[i];

                // 범위 예외 체크
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if(map[nextX][nextY] == 1) {
                    q.offer(new Point(nextX, nextY));
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                }

            }

        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
