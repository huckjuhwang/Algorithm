package 동빈나.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발 {
    static int position;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        int dp[][] = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        // 바라보고 있는 방향 ( 0: 북, 1:동, 2: 남, 3: 서 )
        position = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        ( 0: 북, 1:동, 2: 남, 3: 서 )
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int count = 0;
        int turn_time = 0;

        while (true) {
            turn_left();
            int nx = dx[position] + x;
            int ny = dx[position] + y;

            // 바다가 아니면서, 방문한적이 없다면,
            if (map[nx][ny] != 1 && dp[nx][ny] == 0) {
                dp[nx][ny] = 1;
                x = nx;
                y = ny;
                count++;
            }else{
                turn_time++;
                // 4방향 모두 막혀있다면,
                if (turn_time == 4) {
                    nx = x - dx[position];
                    ny = y - dy[position];
                    // 뒤로 이동 할수 있을 경우, 뒤로이동
                    if (map[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                    }else {
                        // 아닐경우 종료
                        break;
                    }
                    turn_time = 0;
                }

            }
        }
        System.out.println(count);

    }


    /**
     * 왼쪽으로 돌기
     */
    public static void turn_left(){
        position--;
        if (position < 0) {
            position = 3;
        }
    }
}
