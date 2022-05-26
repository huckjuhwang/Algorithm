package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 교환학생_13035 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int min = Integer.MAX_VALUE;
            int arr[] = new int[7];
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 7; i++) {
                int start = i;      // 시작위치이며, 총 횟수를 구할 변수
                int count = 0;      // 일수
                while (true) {
                    if (arr[start++ % 7] == 1) count++;
                    if (n == count) {
                        min = Math.min(min, start - i);
                        break;
                    }
                }

            }

            System.out.println("#" + testCase + " " + min);
        }

    }
}
