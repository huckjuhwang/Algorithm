package 동빈나.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 만들수없는금액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nums[] = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int target = 1;
        for (int i = 0; i < N; i++) {
            // 만들수 없는 금액을 찾을 경우 종료
            if (nums[i] > target) {
                break;
            }
            target += nums[i];
        }
        System.out.println(target);
    }
}
