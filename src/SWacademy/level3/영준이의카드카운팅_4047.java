package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영준이의카드카운팅_4047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();

            int SDHC[][] = new int[4][14];
            int SDHC_cnt[] = new int[4];
            boolean check = true;

            for (int i = 0; i < str.length(); i+=3) {
                String shape = str.substring(i, i+1);
                int num = Integer.parseInt(str.substring((i + 1), (i+1)+2));
                int idx = 0;

                switch (shape) {
                    case "S": idx = 0; break;
                    case "D": idx = 1; break;
                    case "H": idx = 2; break;
                    case "C": idx = 3; break;
                }

                SDHC[idx][num]++;
                SDHC_cnt[idx]++;
                if (SDHC[idx][num] == 2) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.print("#" + testCase + " ");
                for (int i = 0; i < 4; i++) {
                    System.out.print((13-SDHC_cnt[i]) + " ");
                }
                System.out.println();
            }else{
                System.out.println("#" + testCase + " " + "ERROR");
            }
        }
    }
}
