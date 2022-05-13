package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목판정 {

    static char board[][];
    static int visit[][];
    static boolean check;

    // 동서남북 / 동북, 동남, 서북, 서남
    static int dx[] = {0, 0, 1, -1, -1, 1, -1, 1};
    static int dy[] = {1, -1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            board = new char[n][n];
            visit = new int[n][n];
            check = false;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                for (int j = 0; j < n; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'o') {
                        for (int k = 0; k < dx.length; k++) {
                            for (int count = 1; count <= 5; count++) {
                                int nx = i + dx[k] * count;
                                int ny = j + dy[k] * count;

                                // 범위를 벗어났을경우
                                if( nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                                // o가 아닐 경우
                                if (board[nx][ny] != 'o') break;

                                if (count == 4) {
                                    check = true;
                                }
                            }
                        }
                    }
                }
            }
            if (check) {
                System.out.println("#" + testCase + " " + "YES");
            }else{
                System.out.println("#" + testCase + " " + "NO");
            }
        }
    }


}
