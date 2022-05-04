package 동빈나.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP를 사용해서 0~X까지 모든 경우의 수를 비교하고, 가장 작은 횟수를 저장함.
 */
public class 일로만들기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());


        // 5로나누기
        // 3으로 나누기
        // 2로 나누기
        // 1 빼기
        int d[] = new int[30001];

        for (int i = 2; i <= x; i++) {
            d[i] = d[i-1] + 1;
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            } else if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            } else if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }

        System.out.println(d[x]);

    }
}
