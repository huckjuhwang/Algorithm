package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * to-do
 *
 * -- testCase 7/10
 * -- 시간초과 이슈
 */
public class 백만장자프로젝트_1859 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= n; testCase++) {

            int m = Integer.parseInt(br.readLine());
            long sum = 0;

            StringTokenizer st = new StringTokenizer( br.readLine()," ");

            int nums[] = new int[m];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m-1; i++) {

                long max = nums[i];

                for (int j = i+1; j < m; j++) {
                    // setting max
                    if (nums[j] > max) {
                        max = nums[j];
                    }
                }

                // 번 수익에 대한 결과 더하기
                if (max != 0) {
                    sum += max - nums[i];
                }

            }

            System.out.println("#" + testCase +  " "  + sum);
        }
    }
}
