package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팔씨름_13547 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'x') {
                    count++;
                }
            }

            if( count >= 8 ){
                System.out.println("#" + testCase + " " + "NO");
            }else{
                System.out.println("#" + testCase + " " + "YES");
            }
        }
    }
}
