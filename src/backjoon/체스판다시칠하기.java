package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        String board[] = new String[row];
        for (int i = 0; i < row; i++)
            board[i] = br.readLine();


        for (int i = 0; i <= row-8; i++) {
            for (int j = 0; j <= col-8; j++) {
                min = Math.min(min, solve(i, j, board));
            }
        }

        System.out.println(min);
    }

    public static int solve(int r, int c, String board[]) {
        String pull[] = {"WBWBWBWB", "BWBWBWBW"};
        int diff = 0;

        for (int row = r; row < r+8; row++) {
            for (int col = c; col < c+8; col++) {
                if (board[row].charAt(col) != pull[row % 2].charAt(col-c)) {
                    diff++;
                }
            }
        }
        return Math.min(diff, 64-diff);
    }
}
