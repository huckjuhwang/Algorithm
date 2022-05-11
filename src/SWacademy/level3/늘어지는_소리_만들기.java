package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 늘어지는_소리_만들기 {

    // 14분
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            char[] ch = br.readLine().toCharArray();

            int hypen = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int position[] = new int[ch.length+1];
            // 하이픈의 개수를 카운팅한다.
            for (int i = 0; i < hypen; i++) {
                int n = Integer.parseInt(st.nextToken());
                position[n]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch.length; i++) {
                if (position[i] != 0) {
                    for (int j = 0; j < position[i]; j++)    sb.append("-");
                }
                sb.append(ch[i]);
            }


            // 마지막 값에 대한 sb.append
            if (position[ch.length] != 0) {
                for (int i = 0; i < position[ch.length]; i++) {
                    sb.append("-");
                }
            }

            System.out.println("#" + testCase + " " +  sb);
        }
    }
}
