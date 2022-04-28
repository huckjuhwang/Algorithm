package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 암호문1_1228 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;

        for (int testCase = 1; testCase <= t; testCase++) {
            // 암호문의 길이
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> number = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++) {
                number.add(Integer.parseInt(st.nextToken()));
            }
            Integer.parseInt(br.readLine());

            String str[] = br.readLine().split("I");

            for (int i = 1; i < str.length; i++) {
                st = new StringTokenizer(str[i], " ");

                int idx = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());


                for (int j = 0; j < len; j++) {
                    number.add(idx++, Integer.parseInt(st.nextToken()));
                }

            }


            int idx = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("#" + testCase + " ");

            for (Integer num : number) {
                sb.append(num + " ");
                if (++idx == 10)   break;
            }
            System.out.println(sb.toString());
        }
    }
}
