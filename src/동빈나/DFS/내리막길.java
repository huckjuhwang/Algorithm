package 동빈나.DFS;
/**
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS 활용하기 좋다고 추천받아서 풀이 진행
 * https://www.acmicpc.net/problem/1520
 *
 * 알고보니 DFS+DP.. 고통 받다 2시간만에 해결..
 *
 * DP 연습좀 하자ㅠ ㅠ
 */
public class 내리막길 {

    static int arr[][];
    // 상,하,좌,우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        // 도달 했을 경우 추가 탐색 필요 X
        if (x == N - 1 && y == M - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            // 이미 방문을 했기때문에 dfs를 돌지 않아도 된다.
            return dp[x][y];
        } else {
            // 방문 처리
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                // 범위를 초과하는 경우
                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                // 값이 크거나 같을 경우  OR  방문을 했을 경우
                if (arr[x][y] <= arr[nx][ny]) {
                    continue;
                }
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}