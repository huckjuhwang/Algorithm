package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class 세제곱근을찾아라 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            long num = Long.parseLong(br.readLine());
            long x = (long)Math.floor(Math.cbrt(num));
            long val = 0;
            if (x * x * x != num) {
                val = -1;
            }else{
                val = x;
            }

            System.out.println("#" + testCase + " " + val);
        }

    }

    public static HashMap<Long, Integer> getFactorization(long num) {
        long div = 2;
        HashMap<Long, Integer> map = new HashMap<>();

        while (num != 1) {
            while (num % div == 0) {
                if (map.get(div) == null) {
                    map.put(div, 1);
                }else{
                    map.put(div, map.get(div) + 1);
                }
                num /= div;
            }
            div++;
        }
        return map;
    }
}
