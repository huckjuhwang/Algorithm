package backjoon.곰곰컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곰곰컵Q3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int c_cnt = 0;
        int a_cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if( str.charAt(i) == 'C'){
                c_cnt++;
            }else{
                a_cnt++;
            }
        }

        int result = (int)Math.ceil((double) c_cnt / (a_cnt + 1));
        System.out.println(result);
    }
}
