package 구름EDU.공간활용하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열흔들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[n];
        int shiftIdx = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int route = Integer.parseInt(st.nextToken());
            int k = 0;

            switch (route) {
                case 0:
                    int p = Integer.parseInt(st.nextToken());
                    System.out.println(arr[(shiftIdx+p)%n]);
                    break;
                case 1:
                    k = Integer.parseInt(st.nextToken())%n;
                    shiftIdx = (shiftIdx + k) % n;
                    break;
                case 2:
                    k = Integer.parseInt(st.nextToken())%n;
                    shiftIdx = (shiftIdx - k + n) % n;
                    break;
                case 3:
                    shiftIdx = 0;
                    break;

            }

        }

    }
}
