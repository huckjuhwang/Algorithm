package 동빈나.DFS;

//4 5
//00110
//00011
//11111
//00000
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {

    static int arr[][];
    static boolean visit[][];
    static int count;
    static boolean zero;
    static int N, M;

    // 위, 아래, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];
        count = 0;
        zero = false;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && arr[i][j] == 0 ) {
                    zero = false;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x, int y){
        visit[x][y] = true;
        if (zero == false && arr[x][y] == 0) {
            count++;
            zero = true;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            // 범위를 초과 했거나, 뚫려있지 않거나 이미 방문한 경우
            if (nx < 0 || ny < 0 || nx >= N || ny >= M
                    || visit[nx][ny] || arr[nx][ny] != 0){
                continue;
            }else{
                dfs(nx,ny);
            }
        }
    }
}
