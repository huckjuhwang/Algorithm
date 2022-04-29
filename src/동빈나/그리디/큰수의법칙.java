package 동빈나.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰수의법칙 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        // 총 더해주는 횟수
        int M = Integer.parseInt(st.nextToken());
        // 최대로 더해주는 횟수
        int K = Integer.parseInt(st.nextToken());

        int nums[] = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int first = nums[N - 1];
        int second = nums[N - 2];

        int s_num = M%K;
        int f_num = M-s_num;
        System.out.println(first*f_num + second*s_num);

    }
}
