package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 희성이의원근법_6718 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            double km = Double.parseDouble(br.readLine())/1000;
            int val =0;

            if (km < 0.1) {
                val = 0;
            } else if (km >= 0.1 && km < 1) {
                val = 1;
            } else if (km >= 1 && km < 10) {
                val = 2;
            } else if (km >= 10 && km < 100) {
                val = 3;
            } else if (km >= 100 && km < 1000) {
                val = 4;
            }else{
                val = 5;
            }

            System.out.println("#" + testCase + " " + val);
        }
    }
}
