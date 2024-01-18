package backjoon.replay;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2606 {

    static int N, M;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int count = 0;

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(visit, false);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            map[x][y] = 1;
            map[y][x] = 1;
        }

        visit[1] = true;
        q.offer(1);

        while (!q.isEmpty()) {
            int nowComputer = q.poll();

            for(int i =1; i<=N; i++) {
                if(map[nowComputer][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }

        System.out.println(count);

    }

//    static class Point {
//        int x;
//        int y;
//
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

}