package 동빈나.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로찾기 {

    static boolean visit[][];
    static int arr[][];
    static int N,M;
    static int min;

    // 위, 아래, 좌, 우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        visit[0][0] = true;
        dfs(0,0,1);

        System.out.println(min);

    }

    public static void dfs(int x, int y, int count) {

        // 종료 조건
        if (x == N - 1 && y == M - 1) {
            if (min > count) {
                min = count;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            // 괴물이 있거나, 범위를 초과한다면
            if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || arr[nx][ny] == 0 || visit[nx][ny] ) {
                continue;
            }else{
                visit[nx][ny] = true;
                dfs(nx, ny, count+1);
            }
        }
    }
}
