package programmers.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class maze {
    

    static int[][] map;
    static int n;
    static int m;

    static int cnt;
    static boolean visited[][];

    static int[] dx = {-1, 1, 0, 0};    // 상하
    static int[] dy = {0, 0, -1 ,1};   // 좌우


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println("map[n-1][m-1] = " + map[n-1][m-1]);



    }

    public static void bfs(int x, int y){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int nowX = 0;
        int nowY = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            nowX = p[0];
            nowY = p[1];

            for (int i = 0; i < dx.length; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                // 범위 안이라면 or 0이라면
                if (nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > m - 1 || map[nextX][nextY] == 0)  {
                    continue;
                }

                // 방문여부 확인
                if (visited[nextX][nextY]) {
                    continue;
                }

                // 방문 등록
                visited[nextX][nextY] = true;
                // que insert
                map[nextX][nextY] = map[p[0]][p[1]] +1;
                q.add(new int[]{nextX, nextY});
            }
        }



    }


}
