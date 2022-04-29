package 동빈나.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 볼링공고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int nums[] = new int[M+1];


        for (int i = 0; i < N; i++) {
            nums[Integer.parseInt(st.nextToken())]++;
        }

        int sum = 0;

//        for (int i = 1; i <= M; i++) {
//            for (int j = i+1; j <= M; j++) {
//                sum += nums[i] * nums[j];
//            }
//        }

        // 개선 O(M^2) -> O(M)
        for (int i = 1; i <= M; i++) {
            N -= nums[i];
            sum += nums[i] * N;
        }

        System.out.println(sum);

    }
}
