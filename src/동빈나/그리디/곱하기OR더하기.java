package 동빈나.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기OR더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int sum = num.charAt(0) - '0';
        for (int i = 1; i < num.length(); i++) {
            int a = num.charAt(i) - '0';
            if (a != 0 || a != 1) {
                sum *= a;
            }else{
                sum += 1;
            }
        }

        System.out.println(sum);

    }
}
