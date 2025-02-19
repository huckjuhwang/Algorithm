package programmers.pccp;

import java.util.*;

public class Q2 {

    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};

    static int[][] visited;

    static int[] answer;


//    [[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{ // 8 // 7 // 2
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}}));
    }

    public static int solution(int[][] land) {
        answer = new int[land[0].length];

        int max = 0;
        visited = new int[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (visited[i][j] == 0 && land[i][j] == 1) {
                    visited[i][j] = 1;

                    Oil oli = bfs(i, j, land);

                    for (int z = oli.start; z <= oli.end; z++) {
                        answer[z] += oli.value;

                        if (answer[z] > max) {
                            max = answer[z];
                        }
                    }
                }
            }
        }


        return max;
    }

    public static Oil bfs(int startX, int startY, int[][] land) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int count = 1;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            int nowX = poll.x;
            int nowY = poll.y;

            if (nowY < minX) minX = nowY;
            if (nowY > maxX) maxX = nowY;

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + x[i];
                int nextY = nowY + y[i];

                if (nextX < 0 || nextY < 0 || nextX >= land.length || nextY >= land[0].length) {
                    continue;
                }

                if (visited[nextX][nextY] == 0 && land[nextX][nextY] == 1) {
                    visited[nextX][nextY] = 1;
                    q.add(new Point(nextX, nextY));
                    count++;
                }
            }
        }
        return new Oil(minX, maxX, count);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Oil {
        int start;
        int end;
        int value;

        Oil(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

}
