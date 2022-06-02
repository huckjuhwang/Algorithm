package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int freq[] = new int[8001];// +4000으로 넣음(음수 값 때문)

        long sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];      // 모든 합계
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            freq[arr[i] + 4000] += 1;
        }
        Arrays.sort(arr);

        int max_freq = 0;
        int mode= 0;

        // 1번 등장했을경우 true, 아닐경우 false
        boolean check = false;
        // freq중에 가장 높은 값을 가지는 빈도수를 계산
        for (int i = 0; i <= 8000; i++) {
            if (max_freq < freq[i]) {
                max_freq = freq[i];
                mode = i - 4000;
                check = true;
            }
            // 같은 freq가 두번 등장했을 경우
            else if (max_freq == freq[i] && check) {
                mode = i - 4000;
                check = false;
            }
        }


        System.out.println(Math.round((double) sum/n));// 산술평균
        System.out.println(arr[n / 2]);// 중앙 값
        System.out.println(mode);// 최빈 값
        System.out.println(max - min);   // 범위
    }
}
