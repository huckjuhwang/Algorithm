package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다솔이의다이아몬드장식_4751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <5; i++) {


                for (int j = 0; j < str.length(); j++) {
                    if (j == 0) {
                        if (i == 0 || i == 4 || i == 1 || i == 3) {
                            sb.append(".");
                        }else if (i == 2) {
                            sb.append("#");
                        }
                    }

                    if (i == 0 || i == 4) {
                        sb.append(".#..");
                    } else if (i == 1 || i == 3) {
                        sb.append("#.#.");
                    } else if (i == 2) {
                        sb.append(".").append(str.charAt(j)).append(".#");
                    }
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }
}
