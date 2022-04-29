package 동빈나.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열뒤집기 {

    public static char ONE = '1';
    public static char ZERO = '0';

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int zeroCnt = 0;
        int oneCnt = 0;


        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) != number.charAt(i + 1)) {
                if (number.charAt(i) == ZERO) {
                    zeroCnt++;
                }else{
                    oneCnt++;
                }
            }
        }

        if (number.charAt(number.length() - 1) == ZERO) {
            zeroCnt++;
        }else{
            oneCnt++;
        }

        System.out.println(oneCnt < zeroCnt? oneCnt : zeroCnt);
    }
}
