package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class view_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nums[] = new int[n];
            int sum =0;
            // insert
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            // 양끝의 0 2개씩
            for (int i = 2; i < n-2  ; i++) {
                int now = nums[i] - getMax(nums, i);
                if (now > 0) {
                    sum += now;
                }
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }

    private static int getMax(int[] nums, int i) {
        return Math.max(Math.max(nums[i - 1], nums[i - 2]), Math.max(nums[i + 1], nums[i + 2]));
    }
}
