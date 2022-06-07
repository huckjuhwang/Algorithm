package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18111 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // 가로, 최대500;
        int M = Integer.parseInt(st.nextToken());   // 세로
        // 25000

        int B = Integer.parseInt(st.nextToken());

        int ground[][] = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, ground[i][j]);
                min = Math.min(min, ground[i][j]);
            }
        }


        int result_time = Integer.MAX_VALUE;
        int result_height = -1;

        for (int i = min; i <= max; i++) {

            int time = 0;
            int block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int diff = ground[j][k] - i;

                    if (diff < 0) {
                        time += Math.abs(diff);
                        block -= Math.abs(diff);
                    } else if (diff > 0) {
                        time += diff * 2;
                        block += diff;
                    }
                }
            }

            if (block < 0) {
                continue;
            } else if (result_time >= time) {
                result_time = time;
                result_height = i;
            }
        }

        System.out.println(result_time + " " + result_height);
    }
}
