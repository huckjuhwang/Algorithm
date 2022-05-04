package 동빈나.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int d[] = new int[m+1];

        Arrays.fill(d, 10001);
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            d[arr[i]] = 1;
        }


        for (int num : arr){
            for (int j = num; j <=m; j++) {
                if (d[j - num] != 10001) {
                    d[j] = Math.min(d[j], d[j - num]+1);
                }
            }
        }

        if(d[m] == 10001) System.out.println(-1);
        else System.out.println(d[m]);
    }
}
