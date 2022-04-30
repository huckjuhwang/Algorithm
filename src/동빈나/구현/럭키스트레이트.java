package 동빈나.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키스트레이트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int preSum = 0;
        int aftSum = 0;

        for (int i = 0; i < str.length() / 2; i++) {
            preSum += str.charAt(i) - '0';
            aftSum += str.charAt(str.length() - 1 - i) - '0';
        }
        if (preSum == aftSum) {
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }
    }
}
