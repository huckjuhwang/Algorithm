package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 새로운불면증치료법_1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int idx = 1;
            int check[] = new int[10];

            while(true){

                String now = (n * idx) + "";


                for (int i = 0; i < now.length(); i++) {
                    if( check[now.charAt(i) -'0'] == 0 ){
                        check[now.charAt(i) -'0']++;
                    }
                }

                boolean chk = true;
                for (int i = 0; i < check.length; i++) {
                    if (check[i] == 0) {
                        chk = false;
                        break;
                    }
                }

                if (chk) {
                    break;
                }
                idx++;
            }
            System.out.println("#" + testCase + " " +  (idx)*n);
        }
    }
}
