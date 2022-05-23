package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1913 {
    // 위, 우, 하, 좌
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];

        int num = 1;
        int level = 1;
        arr[N/2][N/2] = 1;
        int x = N / 2;
        int y = N / 2;

        while (true) {

            for (int i = 0; i < level; i++) {
                int nx = x - 1;
                if (nx >= 0) {
                    arr[--x][y] = ++num;
                }
            }

            if (num >= N * N) {
                break;
            }


            for (int i = 0; i < level; i++) {
                arr[x][++y] = ++num;
            }

            level++;
            for (int i = 0; i < level; i++) {
                arr[++x][y] = ++num;
            }
            for (int i = 0; i < level; i++) {
                arr[x][--y] = ++num;
            }
            level++;
        }

        System.out.println();

    }
}
