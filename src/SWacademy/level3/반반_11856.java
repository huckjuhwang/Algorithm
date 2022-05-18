package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;


/**
 * 2/5
 */
public class 반반_11856 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                }else{
                    map.put(ch, map.get(ch) + 1);
                }
            }

            boolean check = true;
            for (char key : map.keySet()) {
                if (map.get(key) != 2) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("#" + testCase + " " + "Yes");
            }else{
                System.out.println("#" + testCase + " " + "No");
            }
        }
    }
}
