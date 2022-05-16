package backjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int visit[][];
    static int x, y;

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int arr[][] = new int[x][y];
        visit = new int[x][y];

        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                arr[i][j] = str.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        // bfs
        int distance = getDistance(0, 0, arr);

        bw.write(distance + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getDistance(int M, int N, int[][] arr) {
        // 큐 생성 후 삽입
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(M, N,1, 0));
        visit[M][N] = 0;

        int distance = -1;

        while (!q.isEmpty()) {
            Position poll = q.poll();

            // 목표지점에 도달했을 경우
            if (poll.getX() == (x - 1) && poll.getY() == (y - 1))
                return poll.getDistance();

            for (int i = 0; i < 4; i++) {
                int nx = poll.getX() + dx[i];
                int ny = poll.getY() + dy[i];

                // 범위를 초과했을 경우
                if (nx < 0 || ny < 0 || nx >= x || ny >= y) continue;

                // (부수고 왔을 경우 || 부수지 않을 경우) 일때, 부수지 않은 경우를 선택한다.
                // getDestory값이 크면 부수고 왔다는 뜻
                if (visit[nx][ny] <= poll.getDestroy()) continue;

                // 이동 가능할 때,
                if (arr[nx][ny] == 0) {
                    q.add(new Position(nx, ny, poll.getDistance()+1, poll.getDestroy()));
                    visit[nx][ny] = poll.getDestroy();
                }
                // 벽 && 뿌순횟수가 0일 경우
                else if (arr[nx][ny] == 1 && poll.getDestroy() == 0) {
                    q.add(new Position(nx, ny, poll.getDistance()+1, poll.getDestroy()+1));
                    visit[nx][ny] = poll.getDestroy()+1;
                }
            }

        }
        return distance;
    }
}

class Position {
    private int x;
    private int y;
    private int distance;
    private int destroy;   // 공사 횟수

    public Position(int x, int y, int distance, int destroy) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.destroy = destroy;
    }

    public int getDistance() {
        return distance;
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

    public int getDestroy() {
        return destroy;
    }
}


