package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유효기간_10059 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {

            String num = br.readLine();
            int num1 = Integer.parseInt(num.substring(0, 2));
            int num2 = Integer.parseInt(num.substring(2, 4));

            String result = "";

            boolean check1 = false;
            boolean check2 = false;

            // true이면 월로 사용을 할수 없다는 뜻
            if (num1 > 12 || num1 == 0) {
                check1 = true;
            }

            if (num2 > 12 || num2 == 0) {
                check2 = true;
            }


            if (check1 && check2) {
                result = "NA";
            } else if (check1) {
                result = "YYMM";
            } else if (check2) {
                result = "MMYY";
            }else {
                result = "AMBIGUOUS";
            }

            System.out.println("#" + testCase + " " + result);
        }
    }

}
