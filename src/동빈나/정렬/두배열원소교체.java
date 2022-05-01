package 동빈나.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두배열원소교체 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int a[] = new int[N];
        int b[] = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < K; i++) {
            if (a[i] < b[N - 1 - i]) {
                swap(N, a, b, i);
            }else{
                break;
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += a[i];
        }
        System.out.println(sum);
    }

    private static void swap(int N, int[] a, int[] b, int i) {
        int temp = a[i];
        a[i] = b[N - 1 - i];
        b[N -1- i] = temp;
    }
}
