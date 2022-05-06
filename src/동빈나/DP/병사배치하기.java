package 동빈나.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 병사배치하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d[] = new int[n];
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(d, 1);

        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    d[i] = Math.max(d[j]+1, d[i] );
                }
            }
        }

        // 열외해야 하는 병사의 최소 수를 출력
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, d[i]);
        }
        System.out.println(n - maxValue);

    }
}
