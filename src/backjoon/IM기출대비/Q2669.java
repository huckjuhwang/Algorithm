package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2669 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[][] = new int[101][101];
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int low_x = Integer.parseInt(st.nextToken())+1;
            int low_y = Integer.parseInt(st.nextToken())+1;
            int high_x = Integer.parseInt(st.nextToken());
            int high_y = Integer.parseInt(st.nextToken());

            for (int j = low_x; j <= high_x; j++) {
                for (int k = low_y; k <= high_y; k++) {
                    if (arr[j][k] != 1) {
                        arr[j][k] = 1;
                        sum +=1;
                    }
                }

            }
        }
        System.out.println(sum);

    }
}
