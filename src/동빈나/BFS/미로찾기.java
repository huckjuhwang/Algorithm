package 동빈나.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
        Queue<maze> q = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        visit[0][0] = true;
        q.offer(new maze(0, 0, 1));

        // 빌때 까지
        while (!q.isEmpty()) {
            maze poll = q.poll();
            int count = poll.getVal();

            // 마지막 조건이라면면
           if (poll.getY() == M - 1 && poll.getX() == N - 1) {
               min = count;
               break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.getX();
                int ny = dy[i] + poll.getY();

                // 범위를 초과하거나, 방문했거나, 괴물이 있는 경우는 제외하고 삽입한다.
                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1
                        || arr[nx][ny] == 0 || visit[nx][ny] ) {
                    continue;
                }else {
                    visit[nx][ny] = true;
                    q.add(new maze(nx, ny, count + 1));
                }
            }
        }

        System.out.println(min);
    }

}

class maze{
    private int x;
    private int y;
    private int val;

    public maze(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
