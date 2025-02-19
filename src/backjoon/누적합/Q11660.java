package backjoon.누적합;

import java.util.Scanner;

public class Q11660 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();


        int[][] x = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int number = scan.nextInt();
                x[i][j] += (x[i][j-1] + number);
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();

            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            int sum = 0;

            for(int j= x1; j<=x2; j++) {
                sum += x[j][y2] - x[j][y1-1];
            }
            System.out.println(sum);
        }
    }
}
