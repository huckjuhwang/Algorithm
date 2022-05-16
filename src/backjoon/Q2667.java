package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2667 {

    static int board[][];
    static boolean visited[][];
    static int n;
    static int count;

    static List<Integer> result;

    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }


        Collections.sort(result);

        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }


    public static void dfs(int x, int y) {
        // 종료조건
        count++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어났거나 방문했을 경우
            if (nx < 0 || ny < 0 || nx >= n || ny >= n
                    || visited[nx][ny] || board[nx][ny] == 0)  {
                continue;
            }

            dfs(nx, ny);
        }
    }
}
