package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1244 {

    static int MAN = 1;
    static int WOMAN = 2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switch_num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int switch_stat[] = new int[switch_num+1];

        int idx = 1;
        while (st.hasMoreTokens()) {
            switch_stat[idx++] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (sex == MAN) {
                // 자기가 받은 스위치번호의 배수IDX를 변경해준다.
                for (int j = number; j <= switch_num; j+=number) {
                    switch_stat[j] = (switch_stat[j] == 0) ? 1 : 0;
                }

            } else if (sex == WOMAN) {
                idx = number;
                int range = 1;

                while (true) {
                    int left = idx-range;
                    int right = idx+range;

                    //범위 초과 체크
                    if (left <= 0 || right > switch_num) {
                        range--;
                        break;
                    }
                    // 같다면
                    if (switch_stat[left] == switch_stat[right]) {
                        range++;
                    }else{
                        range--;
                        break;
                    }
                }

                for (int j = number - range; j <= number + range; j++) {
                    switch_stat[j] = (switch_stat[j] == 0) ? 1 : 0;
                }

            }
        }

        for (int i = 1; i <= switch_num; i++) {
            System.out.print(switch_stat[i] + " ");
            if (i % 20 == 0)    System.out.println();
        }

    }
}
