package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두개의숫자열_1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = 0;

            int a[];
            int b[];
            // 입력 받기 a배열이 더 많도록
            if (x > y) {
                st = new StringTokenizer(br.readLine(), " ");
                a = new int[x];
                for (int i = 0; i < x; i++) {
                    a[i] = Integer.parseInt( st.nextToken() );
                }
                st = new StringTokenizer(br.readLine(), " ");
                b = new int[y];
                for (int i = 0; i < y; i++) {
                    b[i] = Integer.parseInt( st.nextToken() );
                }
            }else {
                st = new StringTokenizer(br.readLine(), " ");
                b = new int[x];
                for (int i = 0; i < x; i++) {
                    b[i] = Integer.parseInt( st.nextToken() );
                }
                st = new StringTokenizer(br.readLine(), " ");
                a = new int[y];
                for (int i = 0; i < y; i++) {
                    a[i] = Integer.parseInt( st.nextToken() );
                }
            }


            for (int i = 0; i < a.length-b.length+1; i++) {

                int sub_sum = 0;
                int count = i;
                for (int j = 0; j < b.length; j++) {

                    sub_sum += (a[count++] * b[j]);
                }
                if (sub_sum > sum) {
                    sum = sub_sum;
                }
            }

            System.out.println("#" + testCase + " " + sum);

        }

    }
}
