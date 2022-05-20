package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 승률비교하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            double alice = (double)A / B;
            double bob = (double)C / D;

            if (alice > bob) {
                System.out.println("#" + testCase + " " + "ALICE");
            } else if (alice < bob) {
                System.out.println("#" + testCase + " " + "BOB");
            }else{
                System.out.println("#" + testCase + " " + "DRAW");
            }
        }
    }
}
