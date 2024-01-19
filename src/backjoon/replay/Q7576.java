package backjoon.replay;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {

    static int N, M;
    static int map[][];

    static int x[] = {1, -1, 0, 0};
    static int y[] = {0, 0, 1, -1};

    static Queue<Point> q = new LinkedList<>();

    static int max = 0;

    static boolean zeroCheck = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        M = scan.nextInt();
        N = scan.nextInt();

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = scan.nextInt();

                if(map[i][j] == 1) {
                     q.offer(new Point(i, j, 0));
                }

                if(map[i][j] == 0) {
                    zeroCheck = true;
                }
            }
        }

        // 0이 없다면
        if(!zeroCheck) {
            System.out.println(0);
            return;
        }

        bfs();

        // check zero
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }



        // check max day
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
               max = Math.max(map[i][j], max);
            }
        }
        System.out.println(max);
    }


    public static void bfs() {
        while (!q.isEmpty()) {
            Point poll = q.poll();

            int nowX = poll.x;
            int nowY = poll.y;

            for(int i=0; i<4; i++) {
                int nx = nowX + x[i];
                int ny = nowY + y[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if(map[nx][ny] == 0) {
                    q.add(new Point(nx, ny, poll.point+1));
                    map[nx][ny] = poll.point+1;
                }
            }
        }

    }


    static class Point {
        int x;
        int y;

        int point;

        Point(int x, int y, int point) {
            this.x = x;
            this.y = y;
            this.point = point;
        }
    }
}
