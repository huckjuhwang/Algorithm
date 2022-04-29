package 동빈나.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int rowMin = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                rowMin = Integer.min(rowMin, num);
            }
            max = Integer.max(max, rowMin);
        }
        System.out.println(max);
    }
}
