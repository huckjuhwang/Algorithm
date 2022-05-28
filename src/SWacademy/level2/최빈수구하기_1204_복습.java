package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최빈수구하기_1204_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int grade[] = new int[101];
            for (int i = 0; i < 1000; i++) {
                int number = Integer.parseInt(st.nextToken());
                grade[number]++;
            }

            int max = 0;
            // max값 찾기
            for (int i = 1; i <= 100; i++) {
                max = Math.max(max, grade[i]);
            }

            int result = 0;
            // 가장높은 점수
            for (int i = 100; i > 0; i--) {
                if( max == grade[i] ){
                    result = i;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ").append(result);
            System.out.println(sb);
        }
    }
}
