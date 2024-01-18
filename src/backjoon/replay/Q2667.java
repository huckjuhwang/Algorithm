package backjoon.replay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q2667 {

    static int N;
    static int map[][];
    static int visit[][];

    static int homeCount = 1;

    static int x[] = {1, -1, 0, 0};
    static int y[] = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        map = new int[N][N];
        visit = new int[N][N];

        for(int i=0; i<N; i++) {
            String line = scan.nextLine();
            for(int j=0; j<N; j++) {
                int a = line.charAt(j) - '0';
                map[i][j] = a;
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && visit[i][j] == 0) {
                    count++;
                    visit[i][j] = 1;
                    dfs(new Point(i, j));
                    list.add(homeCount);
                    homeCount = 1;
                }
            }
        }

        System.out.println(count);

        Collections.sort(list);
        for (int homeCount : list) {
            System.out.println(homeCount);
        }

    }


    public static void dfs(Point p) {
        int nowX = p.x;
        int nowY = p.y;

        for(int i=0; i<4; i++) {
            int nextX = nowX + x[i];
            int nextY = nowY + y[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }

            if(map[nextX][nextY] == 1 && visit[nextX][nextY] == 0) {
                visit[nextX][nextY] = 1;
                dfs(new Point(nextX, nextY));
                homeCount++;
            }

        }
    }


    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
