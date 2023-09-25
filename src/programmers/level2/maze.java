package programmers.level2;

import java.util.*;

class maze {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static String[][] map;

    static int[] start = new int[2];

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    }

    public static int solution(String[] maps) {
        int x = maps.length;
        int y = maps[0].length();

        map = new String[x][y];
        int[][] leverVisit = new int[x][y];
        int[][] exitVisit = new int[x][y];

        // visit X이면 -1
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {

                String temp = maps[i].charAt(j) +"";
                if(temp.equals("X")) {
                    leverVisit[i][j] = -1;
                    exitVisit[i][j] = -1;
                } else if(temp.equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }

                map[i][j] = temp;
            }
        }


        /**
         * 레버를 찾고, 출구를 찾는다. 이후, 이동거리 시간을 더해서 리턴
         */
        int lever = bfs("L", leverVisit);
        int exit = bfs("E", exitVisit);

        if(lever == -1 || exit == -1) {
            return -1;
        }

        return lever + exit;
    }


    public static int bfs(String target, int[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visit[start[0]][start[1]] = 1;

        int x = map.length;
        int y = map[0].length;

        while(!q.isEmpty()) {

            int[] temp = q.poll();
            int nowX = temp[0];
            int nowY = temp[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 범위 오버 체크
                if(nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) {
                    continue;
                }

                if(visit[nextX][nextY] == 0) {
                    visit[nextX][nextY] = visit[nowX][nowY] + 1;
                    if(map[nextX][nextY].equals(target)){
                        start[0] = nextX;
                        start[1] = nextY;
                        return visit[nextX][nextY] -1;
                    }

                    q.add(new int[]{nextX, nextY});
                }


            }
        }

        return -1;
    }

}