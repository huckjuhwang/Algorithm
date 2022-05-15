package backjoon.곰곰컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곰곰컵Q6 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[][] = new int[3][2001];

        int range[] = new int[3];
        int start[] = new int[3];
        int end[] = new int[3];


        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            range[i] = Integer.parseInt(st.nextToken());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < 3; i++) {
            int count = end[i] - start[i]+1;
            for (int j = start[i]; j <= 2000; j += range[i]) {
                for (int k = j; k < j+count; k++) {
                    arr[i][k] = 1;
                }
            }
        }


        int idx = -1;

        for (int i = 0; i <= 2000; i++) {
            if (arr[0][i] == 1 && arr[1][i] == 1 && arr[2][i] == 1) {
                idx = i;
                break;
            }
        }

        System.out.println(idx);
    }
}
