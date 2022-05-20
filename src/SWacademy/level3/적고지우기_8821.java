package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 적고지우기_8821 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                int num = str.charAt(i) - '0';

                if (map.get(num) == null) {
                    map.put(num, 1);
                }else{
                    map.remove(num);
                }
            }

            System.out.println("#" + testCase + " " + map.size());
        }
    }
}
