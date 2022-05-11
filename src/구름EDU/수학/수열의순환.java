package 구름EDU.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열의순환 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = arr[0];
        for (int i = 1; i < n; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd;
        }

        System.out.println(answer+1);
    }

    public static int gcd(int a, int b) {

        int x = Math.max(a, b);
        int y = Math.min(a, b);

        while (x % y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return y;
    }
}
