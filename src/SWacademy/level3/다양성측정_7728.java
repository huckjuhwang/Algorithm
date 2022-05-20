package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 다양성측정_7728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            HashMap<Integer, Integer> map = new HashMap<>();
            String n =br.readLine();
            for (int i = 0; i < n.length(); i++) {
                int num = n.charAt(i) - '0';
                if (map.get(num) == null)  map.put(num, 1);
            }

            System.out.println("#" + testCase +" "+ map.size());
        }
    }
}
