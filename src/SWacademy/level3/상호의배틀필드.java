package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드 {

    static String move = "^v<>";
    static String UDLR = "UDLR";
    // 북, 남, 서, 동
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int x, y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            char arr[][] = new char[x][y];
            int lx = 0;
            int ly = 0;
            // 전차의 바라보는 위치
            int idx = 0;

            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();

                // 지도 세팅
                for (int j = 0; j < y; j++) {
                    arr[i][j] = str.charAt(j);

                    // 처음 전차의 위치를 잡는다.
                    for (int k = 0; k < move.length(); k++) {
                        if (str.charAt(j) == move.charAt(k)) {
                            lx = i;
                            ly = j;
                            idx = k;
                        }
                    }
                }
            }

            int len = Integer.parseInt(br.readLine());
            String command = br.readLine();

            for (int i = 0; i < command.length(); i++) {
                char ch = command.charAt(i);

                // next위치 세팅
                int nx = 0;
                int ny = 0;
                char temp = ' ';
                // 전차의 방향을 보여주기 위함
                char route = ' ';

                // 이동 일 경우
                if (UDLR.contains(ch+"")) {
                    switch (ch) {
                        case 'U':  idx = 0;  break;
                        case 'D':  idx = 1;  break;
                        case 'L':  idx = 2;  break;
                        case 'R':  idx = 3;  break;
                    }

                    // 다음 값 찾기
                    nx = lx + dx[idx];
                    ny = ly + dy[idx];
                    route = move.charAt(idx);

                    // 물 이거나, 범위를 초과할 경우 나갈 수 없음
                    if (nx < 0 || ny < 0 || nx >= x || ny >= y || arr[nx][ny] == '-') {
                        arr[lx][ly] = route;
                        continue;
                    }

                    // 벽이여도 이동할수 없음
                    if (arr[nx][ny] == '*' || arr[nx][ny] == '#') {
                        arr[lx][ly] = route;
                        continue;
                    }

                    // 들어갈 수 있는 곳 일 경우, 위치를 바꿈.
                    temp = arr[nx][ny];
                    arr[nx][ny] = arr[lx][ly];
                    arr[lx][ly] = temp;

                    // 현재 위치를 수정함.
                    lx = nx;
                    ly = ny;
                    arr[lx][ly] = route;
                }else{
                    int count = 1;
                    // 공격일 경우
                    nx = lx + dx[idx]* count;
                    ny = ly + dy[idx]* count;

                    while (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                        // 강철벽을 만나면 종료함
                        if( arr[nx][ny] == '#') break;

                        // 벽돌벽을 만나면 부수고 종료함
                        if (arr[nx][ny] == '*') {
                            arr[nx][ny] = '.';
                            break;
                        }

                        count++;
                        nx = lx + dx[idx]* count;
                        ny = ly + dy[idx]* count;
                    }
                }
            }


            // 결과 출력
            System.out.print("#" + testCase + " ");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }



        }
    }
}
