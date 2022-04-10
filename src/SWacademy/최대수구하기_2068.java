package SWacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 최대수구하기_2068 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");

            int max = 0;
            for (int j = 0; j < str.length; j++) {
                int nowN = Integer.parseInt(str[j]);

                if (max < nowN) {
                    max = nowN;
                }
            }
            System.out.println("#" + (i + 1) + " " + max);
        }
    }
}
