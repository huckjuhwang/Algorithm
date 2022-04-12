package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 패턴마다의길이_2007 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            // 반복되는 문자를 찾음
            for (int j = 1; j <= str.length(); j++) {

                String nowSTR = str.substring(0, j);
                String nextSTR = str.substring(j, j + j);

                if (nowSTR.equals(nextSTR)) {
                    System.out.println("#" + i + " " + nowSTR.length());
                    break;
                }
            }

        }
    }
}
