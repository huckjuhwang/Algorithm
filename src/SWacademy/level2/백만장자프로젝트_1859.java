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

            long max = nums[m-1];
            // 뒤에서 부터 계산 하더록
            for (int i = m; i > 0; i--) {
                if( max < nums[i-1]){
                    max = nums[i-1];
                }

                sum += max - nums[i - 1];
            }

            System.out.println("#" + testCase +  " "  + sum);
        }
    }
}
