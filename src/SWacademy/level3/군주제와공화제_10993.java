package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 군주제와공화제_10993 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int x[] = new int[n];
            int y[] = new int[n];
            int s[] = new int[n];

            // j가 i를 공격했을때, 공격 가능하면 1, 아니면 0
            int si[][] = new int[n][n];
            // i번의 공격을 당할수 있을때,
            int count[] = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                s[i] = Integer.parseInt(st.nextToken());
            }

            // 각 도시에대한 위협당하는 도시를 구한다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if( i == j ) continue;

                    double mo = (Math.pow(Math.abs(x[i] - x[j]), 2)
                                        + Math.pow(Math.abs(y[i] - y[j]), 2));
                    // 2번이 1번을 공격
                    double attack = s[j] / mo;

                    // i보다 j의 영향력이 더크다면,
                    if (s[i] < attack) {
                        // j번이 i번을 공격할수 있다.
                        si[i][j] = 1;
                        count[i]++;
                    }
                }
            }


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (count[i] == 0) {
                    sb.append("K ");
                } else if (count[i] == 1) {
                    boolean check = true;
                    int val = i;
                    while (check) {
                        for (int j = 0; j < n; j++) {
                            if (si[val][j] == 1) {
                                if (count[j] != 1) {
                                    sb.append((j+1) + " ");
                                    check = false;
                                }else{
                                    val = j;
                                    break;
                                }
                            }
                        }
                    }

                } else if (count[i] >= 2) {
                    sb.append("D ");
                }
            }

            System.out.println("#" + testCase + " " + sb);
        }
    }
}
