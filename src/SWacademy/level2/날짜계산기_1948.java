package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산기_1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int day[] = {0 ,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int stm = Integer.parseInt(st.nextToken());
            int std = Integer.parseInt(st.nextToken());
            int enm = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int i = stm; i < enm; i++) {
                sum += day[i];
            }

            System.out.println("#" + testCase + " " +  (sum+(end-std)+1));
        }
    }
}
