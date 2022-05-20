package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세상의모든팰린드롬2_4579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();
            String reverse = new StringBuilder(str).reverse().toString();

            boolean check = true;
            for (int i = 0; i < str.length()/2; i++) {
                if ( str.charAt(i) == '*' || reverse.charAt(i) == '*'){
                    check = true;
                    break;
                }
                if (str.charAt(i) != reverse.charAt(i)) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("#" + testCase + " " + "Exist");
            }else{
                System.out.println("#" + testCase + " " + "Not exist");
            }

        }
    }
}
