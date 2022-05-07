package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1913 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];
        int number = 1;
        int center = (n / 2);
        int x = center;
        int y = center;

        int level = 1;

        while (true) {
            for (int i = 0; i < level; i++) {
                arr[x--][y] = number++;
            }
            if (number >= (n * n))   break;
            for (int i = 0; i < level; i++) {
                arr[x][y++] = number++;
            }
            level++;


            for (int i = 0; i < level; i++) {
                arr[x++][y] = number++;
            }

            for (int i = 0; i < level; i++) {
                arr[x][y--] = number++;
            }
            level++;

        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j] + " ");
                if (target == arr[i][j]) {
                    x = i;
                    y = j;
                }
            }
            sb.append("\n");
        }

        sb.append((x+1) + " " + (y+1));
        System.out.println(sb);
    }
}
