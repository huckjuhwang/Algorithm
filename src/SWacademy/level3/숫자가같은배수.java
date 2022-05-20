package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자가같은배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();

            char numbers[] = str.toCharArray();
            Arrays.sort(numbers);
            String sortNum = new String(numbers);


            int num = Integer.parseInt(str);

            boolean check = false;
            for (int i = 2;; i++) {
                int sub = num * i;
                if (Integer.toString(sub).length() != numbers.length)  break;

                char[] chars = Integer.toString(sub).toCharArray();
                Arrays.sort(chars);
                String multiNum = new String(chars);

                if (sortNum.equals(multiNum)) {
                    check = true;
                    break;
                }
            }

            if (check) {
                System.out.println("#" + testCase +" " + "possible");
            }else{
                System.out.println("#" + testCase +" " + "impossible");
            }
        }
    }
}
