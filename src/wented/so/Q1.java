package wented.so;

import java.util.*;

public class Q1 {

    static int map[][];

    public static void main(String[] args) {
        solution(6, 17, new int[][]{{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}});

//        solution(4, 10, new int[][]{{0, 1, 2}, {0, 2, 3}});
    }

    public static int[] solution(int n, int k, int[][] roads) {
        List<Integer> result = new ArrayList<>();

        map = new int[n][n];

        for(int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int c = road[2];

            map[a][b] = c;
            map[b][a] = c;
        }


        for (int goal = 0; goal < n; goal++) {
            if (bfs(0, goal, k, n)) {
                System.out.println("ddd " + goal);
                result.add(goal);
            }
        }

        Collections.sort(result);

        if(result.size() == 0) {
            return new int[]{-1};
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    // 각 도착지 노드별로 호출해주면 된다.
    public static boolean bfs(int start, int end, int k, int n) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start, k));

        while (!q.isEmpty()) {
            Point p = q.poll();
            int nowP = p.position;
            int nowK = p.rentalTime;


            for(int i =0; i<n; i++) {
                int nextP = i;
                int nextK = nowK - map[nowP][i];  // 남은 시간(가진시간 - 이동한시간)

                if(nextK == 0 && nextP == end)
                    return true;

                if(map[nowP][nextP] != 0 && nextK > 0) {
                    q.offer(new Point(nextP, nextK)); // 이동한 위치, 남은시간
                }
            }
        }
        return false;
    }



    static class Point {
        int position;
        int rentalTime;

        Point(int position, int rentalTime) {
            this.position = position;
            this.rentalTime = rentalTime;
        }
    }
}
